package service;

import entity.TicketEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import repository.TicketRepo;

import java.util.Collections;


@Service
@Data
@AllArgsConstructor
public class TicketService implements ApplicationContextAware {
    Logger logger;
    ApplicationContext ctx;
    TicketRepo repository;

    public void byTicket(TicketEntity t){
        repository.save(t);
    }

    public void returnTicket(Integer id){
        repository.deleteAllById(Collections.singleton(id));
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        this.ctx = applicationContext;
    }

}
