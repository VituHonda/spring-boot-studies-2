package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.dto.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dto.ProdutoResponseDto;
import br.com.fiap.ecommerce.model.Produto;
import br.com.fiap.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoResponseDto> list() {
        List<Produto> produtos = produtoService.list();
        return null;
    }

    @PostMapping
    public ProdutoResponseDto create(ProdutoRequestCreateDto dto) {
        return null;
    }

    @GetMapping("/id")
    public Produto findById() {
        return null;
    }

    @PutMapping("/id")
    public void update() {

    }

    @DeleteMapping("/id")
    public void delete() {

    }


}
