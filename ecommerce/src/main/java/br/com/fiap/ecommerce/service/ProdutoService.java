package br.com.fiap.ecommerce.service;

import br.com.fiap.ecommerce.model.Produto;
import br.com.fiap.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> list() {
        return produtoRepository.findAll();
    }

}
