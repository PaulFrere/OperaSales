package service;

import org.springframework.stereotype.Service;


@Service
public interface TicketService {
   void buyTicket(String name, int place);
   void returnTicket(String name, int ticket);
}
