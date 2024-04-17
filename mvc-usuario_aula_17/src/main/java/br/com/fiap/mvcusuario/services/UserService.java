package br.com.fiap.mvcusuario.services;

import br.com.fiap.mvcusuario.models.User;
import br.com.fiap.mvcusuario.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        User user = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado")
        );
        return user;
    }

    @Transactional
    public User insert(User user) {
        user.setMoment(Instant.now());
        return repository.save(user);
    }

    @Transactional
    public User update(User user) {
        user.setMoment(Instant.now());
        return repository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
