package repository;

import entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<TicketEntity, Integer> {
}
