package event;

import dto.Ticket;
import org.springframework.context.ApplicationEvent;

public class BuyEvent extends ApplicationEvent {
    public BuyEvent(Ticket source){
        super(source);
    }
}
