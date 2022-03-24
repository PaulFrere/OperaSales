package service;

import entity.EventEntity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import repository.EventRepo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.LockModeType;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@Service
public class EventService implements ApplicationContextAware {

    private Logger logger;
    private ApplicationContext ctx;
    private EventRepo repository;
    private TransactionTemplate txTemplate;

    @Autowired
    public EventService(Logger logger, EventRepo repository,TransactionTemplate txTemplate){
        this.logger = logger;
        this.repository = repository;
        this.txTemplate = txTemplate;
    }
    public void addEvent(EventEntity e) {
        txTemplate.executeWithoutResult((status)->{
          try {
              repository.save(e);
          }catch(Exception err){
              System.err.println(err);
              status.setRollbackOnly();
          }
        });
        repository.save(e);
    }

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    public EventEntity getEventById(Integer id)
    {
        try {
            return repository.getById(id);
        }catch (Exception err){
            System.err.println(err.getMessage());
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 3,
            rollbackFor = {IOException.class, FileNotFoundException.class, EOFException.class},
            noRollbackFor = {RuntimeException.class}
    )
    public void editEvent(EventEntity e){
        try {
            repository.save(e);
        }catch (Exception err){
            System.err.println(err.getMessage());
        }
    }
    public void deleteEvent(Integer id){
        repository.deleteById(id);
    }
    public List<EventEntity> getList(){
        return repository.findAll();
    }

    @PostConstruct
    public void init(){
        logger.print("Service create " + this.getClass().getSimpleName());
    }
    @PreDestroy
    public void destroy(){
        logger.print("Service completed" + this.getClass().getSimpleName());
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException{
        this.ctx = ctx;
    }
}
