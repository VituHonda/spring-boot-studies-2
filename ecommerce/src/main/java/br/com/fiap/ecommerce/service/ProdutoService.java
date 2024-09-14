package br.com.fiap.ecommerce.service;

import br.com.fiap.ecommerce.model.Produto;
import br.com.fiap.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> list() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

   public Produto update(Long id, Produto produto) {
        return null;
   }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }


    public boolean existsById(Long id) {
        return produtoRepository.existsById(id);
    }
}
