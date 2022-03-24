package repository;

import entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<EventEntity, Integer> {
    void deleteById(Integer id);

    EventEntity getById(Integer id);
}
