package service;

import entity.Ticket;
import repository.TicketRepo;

public class TicketServiceImpl implements TicketService{

    private TicketRepo ticketRepo;
    private ConsoleLogger logger;

    @Override
    public void buyTicket(String name, int place){
        Ticket ticket = new Ticket(name, place);
        ticketRepo.save(ticket);
    }

    @Override
    public void returnTicket(String name, int ticket) {
        logger.log(ticketRepo.get(name, ticket));
    }
}
