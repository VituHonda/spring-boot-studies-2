package br.com.fiap.ecommerce.dto;

import br.com.fiap.ecommerce.model.Produto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class ProdutoResponseDto {

    private Long id;
    private String nome;
    private ModelMapper mapper = new ModelMapper();

    public ProdutoResponseDto toDto(Produto produto) {
        return mapper.map(produto, ProdutoResponseDto.class);
    }
}
