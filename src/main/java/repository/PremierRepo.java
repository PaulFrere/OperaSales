package repository;

import entity.Premier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremierRepo extends JpaRepository<Premier, Integer> {
    Premier getPremierByName (String name);
}
