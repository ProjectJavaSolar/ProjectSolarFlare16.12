package space.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}