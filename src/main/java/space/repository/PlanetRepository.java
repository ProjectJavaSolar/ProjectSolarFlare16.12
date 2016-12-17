package space.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import space.entity.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {
}
