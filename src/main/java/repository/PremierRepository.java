package repository;

import entity.Premier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremierRepository extends JpaRepository<Premier, Long> {
    Premier getPremierByTitleContains(String title);
}
