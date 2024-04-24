package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.models.Categoria;
import br.com.fiap.produtomvc.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    // Injeção de dependência de repository
    @Autowired
    private CategoriaRepository repository;

    //Método que retorna uma lista de Categoria
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    //Método para inserir Categoria
    @Transactional
    public Categoria insert(Categoria categoria) {
        return repository.save(categoria);
    }

    //Método para buscar Categoria por Id
    @Transactional(readOnly = true)
    public Categoria findById(Long id) {

        Categoria categoria = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );
        return categoria;
    }

    //Método para atualiza Categoria
    @Transactional
    public Categoria update(Long id, Categoria entity) {

        try {
            Categoria categoria = repository.getReferenceById(id);
            copyToCategoria(entity, categoria);
            categoria = repository.save(categoria);
            return categoria;
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    // Método para excluir categoria
    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Falha de integridade referencial - id: " + id);
        }
    }

    //Método para copiar dados entre objetos
    private void copyToCategoria(Categoria entity, Categoria categoria) {
        categoria.setNome(entity.getNome());
    }


}



