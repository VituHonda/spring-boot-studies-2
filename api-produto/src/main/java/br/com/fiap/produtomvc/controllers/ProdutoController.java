package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.dto.ProdutoDTO;
import br.com.fiap.produtomvc.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findall() {
        List<ProdutoDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    


}
