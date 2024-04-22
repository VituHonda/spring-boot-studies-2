package br.com.fiap.mvcusuario.services;

import br.com.fiap.mvcusuario.dto.UserDTO;
import br.com.fiap.mvcusuario.models.User;
import br.com.fiap.mvcusuario.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public User findById(Long id){

        User user = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado")
        );

        return user;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<User> list = repository.findAll();
       return  list.stream().map(UserDTO::new).collect(Collectors.toList());

    }

    @Transactional
    public User insert (User user){
        user.setMoment(Instant.now());
        return repository.save(user);
    }

    @Transactional
    public User update ( User user){
        return repository.save(user);
    }

    @Transactional
    public void delete (Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Usuário inválido - id: " + id);
        }
        try{
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Falha de integridade referencial");
        }
    }
}
