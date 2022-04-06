package repository;

import entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    List<Ticket> getAllByNameOfOpera();
    Ticket get(String name, int place);
    Object save(Ticket ticket);
    void delete(Ticket ticket);
    void buyTicket(String name, int place);
    void returnTicket(String name, int place);
}
