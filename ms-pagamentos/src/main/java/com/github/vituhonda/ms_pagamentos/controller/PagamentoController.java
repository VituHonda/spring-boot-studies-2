package com.github.vituhonda.ms_pagamentos.controller;

import com.github.vituhonda.ms_pagamentos.dto.PagamentoDTO;
import com.github.vituhonda.ms_pagamentos.model.Pagamento;
import com.github.vituhonda.ms_pagamentos.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jdk.javadoc.doclet.Reporter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> findAll() {
        List<PagamentoDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> findById(@PathVariable Long id) {
        PagamentoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<PagamentoDTO> insert(@RequestBody @Valid PagamentoDTO dto) {

        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDTO> update(@PathVariable @NotNull Long id, @RequestBody @Valid PagamentoDTO dto) {
        dto = service.update(id,dto);
        return ResponseEntity.ok(dto);
    }

}
