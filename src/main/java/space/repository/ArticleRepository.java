package space.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
