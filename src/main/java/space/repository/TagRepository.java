package space.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByName(String name);
}
