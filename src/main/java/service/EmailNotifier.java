package service;

import dto.Ticket;
import event.BuyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotifier implements ApplicationListener<BuyEvent> {
    @Override
    public void onApplicationEvent(BuyEvent event){
        Ticket ticket = (Ticket) event.getSource();
        System.out.println("Buy ticket on " + ticket.getEventName());
    }
}
