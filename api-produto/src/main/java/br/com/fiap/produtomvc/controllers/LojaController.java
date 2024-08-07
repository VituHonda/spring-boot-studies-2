package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.dto.LojaDTO;
import br.com.fiap.produtomvc.services.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaService service;

    @GetMapping
    public ResponseEntity<List<LojaDTO>> findAll(){
        List<LojaDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<LojaDTO> findById(@PathVariable Long id){
        LojaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
