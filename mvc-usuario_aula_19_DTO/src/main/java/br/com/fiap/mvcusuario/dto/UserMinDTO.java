package br.com.fiap.mvcusuario.dto;

import br.com.fiap.mvcusuario.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.time.LocalDate;

public class UserMinDTO {

    private Long id;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "Campo requerido")
    private String email;

    @NotBlank(message = "Campo requerido")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;

    public UserMinDTO() {
    }

    public UserMinDTO(Long id, String nome, String email, LocalDate dataNascimento, Instant moment, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public UserMinDTO(User entity) {
        id = entity.getId();
        email = entity.getEmail();
        senha = entity.getSenha();    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
