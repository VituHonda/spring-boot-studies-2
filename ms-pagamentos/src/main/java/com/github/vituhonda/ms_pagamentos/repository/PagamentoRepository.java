package com.github.vituhonda.ms_pagamentos.repository;

import com.github.vituhonda.ms_pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
