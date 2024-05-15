package br.com.fiap.produtomvc.repository;

import br.com.fiap.produtomvc.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
