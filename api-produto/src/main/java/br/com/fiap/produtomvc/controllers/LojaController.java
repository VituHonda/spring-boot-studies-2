package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.dto.LojaDTO;
import br.com.fiap.produtomvc.services.LojaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<LojaDTO> insert(@RequestBody @Valid LojaDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
