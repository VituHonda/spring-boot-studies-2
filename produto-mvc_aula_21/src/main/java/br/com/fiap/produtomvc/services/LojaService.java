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
    public Loja insert(Loja loja) {
        return repository.save(loja);
    }

    @Transactional(readOnly = true)
    public Loja findById(Long id) {
        Loja loja = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido")
        );
        return loja;
    }

    public Loja update(Long id, Loja entity) {
        try {
            Loja loja = repository.getReferenceById(id);
            copyToLoja(entity, loja);
            loja = repository.save(loja);
        } catch(Exception e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }
        return entity;
    }

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



    private void copyToLoja(Loja entity, Loja loja) {
        loja.setNome(entity.getNome());
        loja.setProdutos(entity.getProdutos());
    }

}
