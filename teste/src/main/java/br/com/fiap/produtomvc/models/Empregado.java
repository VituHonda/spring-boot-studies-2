package br.com.fiap.produtomvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_empregado")
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private Double salario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_empregado_projeto",
    joinColumns = @JoinColumn(name = "empregado_id"),
    inverseJoinColumns = @JoinColumn(name = "projeto_id"))
    private Set<Projeto> projetos = new HashSet<>();

    @Override
    public String toString() {
        return "Empregado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empregado empregado = (Empregado) o;
        return Objects.equals(id, empregado.id) && Objects.equals(nome, empregado.nome) && Objects.equals(email, empregado.email) && Objects.equals(salario, empregado.salario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, salario);
    }
}
