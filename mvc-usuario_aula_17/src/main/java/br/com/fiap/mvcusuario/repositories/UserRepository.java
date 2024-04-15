package br.com.fiap.mvcusuario.repositories;

import br.com.fiap.mvcusuario.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
