package space.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import space.entity.FunFact;


public interface FunFactRepository extends JpaRepository<FunFact, Integer>{
}
