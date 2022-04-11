package repository;

import entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepo extends JpaRepository<EventEntity, Integer> {
    void deleteById(Integer id);

    EventEntity getById(Integer id);

    @Query("From EventEntity e order by e.id")
    List<EventEntity> findAllOrderById();
}
