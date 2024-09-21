package br.com.fiap.ecommerce.dto;

import br.com.fiap.ecommerce.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoRequestCreateDto {
    private String nome;
    private ModelMapper mapper = new ModelMapper();

    public Produto toModel() {
        return mapper.map(this, Produto.class);
    }
}
