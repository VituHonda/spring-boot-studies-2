package br.com.fiap.produtomvc.dto;

import br.com.fiap.produtomvc.models.Loja;
import br.com.fiap.produtomvc.models.Produto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO {

    @Schema(description = "ID do produto gerado pelo banco de dados")
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    @Schema(description = "Nome do produto")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @Schema(description = "Descrição do produto")
    private String descricao;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")
    @Schema(description = "Valor do produto")
    private Double valor;

    private CategoriaDTO categoria;

    private List<LojaDTO> lojas = new ArrayList<>();

    public ProdutoDTO(Produto entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        valor = entity.getValor();
        categoria = new CategoriaDTO(entity.getCategoria());

        for(Loja loja : entity.getLojas()){
            lojas.add(new LojaDTO(loja));
        }
    }
}
