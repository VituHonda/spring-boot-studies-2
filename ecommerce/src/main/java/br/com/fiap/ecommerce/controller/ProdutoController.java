package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.dto.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dto.ProdutoRequestUpdateDto;
import br.com.fiap.ecommerce.dto.ProdutoResponseDto;
import br.com.fiap.ecommerce.model.Produto;
import br.com.fiap.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoResponseDto> list() {
        return produtoService.list()
                .stream()
                .map(e -> new ProdutoResponseDto().toDto(e))
                .toList();
    }

    @PostMapping
    public ProdutoResponseDto create(@RequestBody ProdutoRequestCreateDto dto) {



        return null;
    }

    @PutMapping("{id}")
    public ProdutoResponseDto update(@PathVariable Long id, @RequestBody ProdutoRequestUpdateDto dto) {
        if(!produtoService.existsById(id)) {
            new RuntimeException("id inexistente");
        }
        // ProdutoUpdatedto -> produto
        // produto saved = service.save(produto)
        // saved - > produtoResponse
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if(!produtoService.existsById(id)) {
            new RuntimeException("id inexistente");
        }
        produtoService.delete(id);
    }

    @GetMapping("{id}")
    public ProdutoResponseDto findById(@PathVariable Long id) {
        Optional<Produto> opt = produtoService.findById(id);
        Produto produto = null;
        if(opt.isPresent()) {
            produto = opt.get();
        } else {
            new RuntimeException("id inexistente");
        }
        return null;
    }


}
