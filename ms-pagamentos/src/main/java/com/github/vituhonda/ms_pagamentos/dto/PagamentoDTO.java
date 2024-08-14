package com.github.vituhonda.ms_pagamentos.dto;

import com.github.vituhonda.ms_pagamentos.model.Pagamento;
import com.github.vituhonda.ms_pagamentos.model.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PagamentoDTO {

    private Long id;

    @NotNull(message = "Campo obrigatório")
    @Positive(message = "O valor dele ser positivo")
    private BigDecimal valor;

    @Size(max = 100, message = "Máximo de 100 caracteres")
    private String nome;

    @Size(max = 19, message = "Máximo de 19 caracteres")
    private String numeroDoCartao;

    @Size(min = 5, max = 5, message = "Validade do cartão deve ter 5 caracteres")
    private String validade;

    @Size(min = 3, max = 3, message = "Código de segurança deve ter 3 caracteres")
    private String codigoDeSeguranca;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @NotNull(message = "Pedido ID obrigatório")
    private Long pedidoId;

    @NotNull(message = "Forma de pagamento obrigatório")
    private Long formaDePagamentoId;

    public PagamentoDTO(Pagamento entity) {
        id = entity.getId();
        valor = entity.getValor();
        nome = entity.getNome();
        numeroDoCartao = entity.getNumeroDoCartao();
        validade = entity.getValidade();
        codigoDeSeguranca = entity.getCodigoDeSeguranca();
        status = entity.getStatus();
        pedidoId = entity.getPedidoId();
        formaDePagamentoId = entity.getFormaDePagamentoId();
    }




}
