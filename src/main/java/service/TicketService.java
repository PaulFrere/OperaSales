package service;

import dto.Ticket;
import entity.TicketEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import repository.TicketRepo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


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
        repository.deleteById(id);
    }


    private List<Ticket> toDomain(List<TicketEntity> entities){
        return entities.stream()
                .map(TicketService::toDomain).collect(Collectors.toList());
    }

    private static Ticket toDomain(TicketEntity ticket){
        return new Ticket(ticket.getId(), ticket.getPrice(), ticket.getEvent().getName());
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        this.ctx = applicationContext;
    }

    public List<Ticket> getETickets(Integer id){
        return toDomain(repository.getTicketEntitiesByEvent_Id(id));
    }
}
