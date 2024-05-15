package br.com.fiap.produtomvc.dto;

import br.com.fiap.produtomvc.models.Departamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DepartamentoDTO {

    private long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    public DepartamentoDTO(Departamento entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }
}
