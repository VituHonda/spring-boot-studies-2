package br.com.fiap.produtomvc.repository;

import br.com.fiap.produtomvc.models.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
}
