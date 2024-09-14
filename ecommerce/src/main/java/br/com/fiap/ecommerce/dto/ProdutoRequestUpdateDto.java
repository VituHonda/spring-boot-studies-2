package br.com.fiap.ecommerce.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequestUpdateDto {
    private Long id;
    private String nome;
}
