package br.com.fiap.produtomvc.repository;

import br.com.fiap.produtomvc.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
