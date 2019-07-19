package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
