package br.com.fiap.produtomvc.dto;

import br.com.fiap.produtomvc.models.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CategoriaDTO {

    @Schema(description = "ID da categoria gerada pelo banco de dados")
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    @Schema(description = "Nome da categoria")
    private String nome;

    public CategoriaDTO(Categoria entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

}



