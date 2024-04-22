package br.com.fiap.mvcusuario.repositories;

import br.com.fiap.mvcusuario.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Long> {
    //    //update tb_user set nome='aaa', email = 'slsl@d.c', data_nascimento = '2000-01-01' where id =3
//    @Transactional
//    @Modifying
//    @Query(nativeQuery = true, value = """
//            UPDATE tb_user
//            SET nome= :nome, email = :email, data_nascimento = :dataNascimento
//            WHERE id =3
//            """)
//    void updateParcial(String nome, String email, LocalDate dataNascimento, Long id);
//    @Transactional
//    @Modifying()
//
//    @Query("UPDATE User u SET u.nome = :nome, u.email = :u.email, u.dataNascimento = : dataNascimento WHERE u.id = :id")
//    User updateParcial(String nome, String email, LocalDate dataNascimento, Long id);
//

}
