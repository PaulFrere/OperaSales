package repository;

import entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<TicketEntity, Integer> {
    public List<TicketEntity> getTicketEntitiesByEventId(Integer id);
}
