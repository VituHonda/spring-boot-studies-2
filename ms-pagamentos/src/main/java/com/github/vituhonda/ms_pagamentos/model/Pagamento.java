package com.github.vituhonda.ms_pagamentos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pagamento {

    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numeroDoCartao;
    private String validade;
    private String codigoDeSeguranca;
    private Status status;
    private Long pedidoId;
    private Long formaDePagamentoId; // 1 - dinheiro | 2 - cartão | 3 - pix

}
