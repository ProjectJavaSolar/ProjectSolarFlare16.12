package space.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.entity.Category;

public interface CategoryRepository
   extends JpaRepository<Category, Integer>{




}
