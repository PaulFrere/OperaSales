package service;

import dto.Event;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventService implements ApplicationContextAware {

    private Logger logger;
    private ApplicationContext ctx;
    private EventRepo repo;
    private TransactionTemplate txTemplate;

    @Autowired
    public EventService(Logger logger, EventRepo repo,TransactionTemplate txTemplate){
        this.logger = logger;
        this.repo = repo;
        this.txTemplate = txTemplate;
    }
    public Integer addEvent(EventEntity e) {
        EventEntity es =repo.save(e);
        return es.getId();
    }

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    public Event getEventById(Integer id)
    {
        try {
            return toDomain(repo.getById(id));
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
            repo.save(e);
        }catch (Exception err){
            System.err.println(err.getMessage());
        }
    }
    public void deleteEvent(Integer id){
        repo.deleteById(id);
    }

    public List<Event> getList(){
        return toDomain(repo.findAllOrderById());
    }

    private List<Event> toDomain(List<EventEntity> entities){
        return entities.stream()
                .map(EventService::toDomain).collect(Collectors.toList());
    }

    private static Event toDomain(EventEntity entity){
        return new Event(entity.getId(), entity.getName());
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
