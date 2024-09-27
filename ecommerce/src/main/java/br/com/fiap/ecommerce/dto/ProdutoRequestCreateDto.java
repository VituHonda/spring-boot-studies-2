package br.com.fiap.ecommerce.dto;

import br.com.fiap.ecommerce.model.Produto;
import lombok.*;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoRequestCreateDto {
    private String nome;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private ModelMapper mapper = new ModelMapper();

    public Produto toModel() {
        return mapper.map(this, Produto.class);
    }
}
