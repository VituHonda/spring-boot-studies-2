package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping
    public List<Produto> list() {
        return null;
    }

}
