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
public class ProdutoRequestUpdateDto {
    private String nome;

    private ModelMapper mapper = new ModelMapper();

    public Produto toModel(Long id) {
        Produto result = mapper.map(this, Produto.class);
        result.setId(id);
        return result;
    };
}
