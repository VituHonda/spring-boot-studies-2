package br.com.fiap.produtomvc.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpregadoDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    @Email
    private String email;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")
    private Double salario;

}
