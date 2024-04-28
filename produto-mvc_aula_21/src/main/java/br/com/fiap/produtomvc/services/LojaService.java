package br.com.fiap.produtomvc.services;

import br.com.fiap.produtomvc.models.Loja;
import br.com.fiap.produtomvc.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    @Transactional(readOnly = true)
    public List<Loja> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Loja findById(Long id) {
        Loja entity = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido")
        );
        return entity;
    }

    @Transactional
    public Loja update(Long id, Loja entity) {
        try {
            Loja loja = repository.getReferenceById(id);
            loja.setNome(entity.getNome());
            loja = repository.save(loja);
            return loja;
        } catch(Exception e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Loja inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (Exception e){
            throw new IllegalArgumentException("Loja inválido - id: " + id);
        }
    }

}
