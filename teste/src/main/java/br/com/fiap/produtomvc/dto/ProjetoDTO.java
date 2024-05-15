package br.com.fiap.produtomvc.dto;

import br.com.fiap.produtomvc.models.Projeto;
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
public class ProjetoDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    public ProjetoDTO(Projeto entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }
}
