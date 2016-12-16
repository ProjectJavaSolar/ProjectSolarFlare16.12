package space.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import space.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}