package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.dto.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dto.ProdutoRequestUpdateDto;
import br.com.fiap.ecommerce.dto.ProdutoResponseDto;
import br.com.fiap.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> list() {
        List<ProdutoResponseDto> dtos = produtoService.list()
                .stream()
                .map(e -> new ProdutoResponseDto().toDto(e))
                .toList();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> create(@RequestBody ProdutoRequestCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ProdutoResponseDto().toDto(
                        produtoService.save(dto.toModel())
                )
        );
    }

/////////////////////////////////////////////////////////////////////////////////

    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponseDto> update(@PathVariable Long id, @RequestBody ProdutoRequestUpdateDto dto) {
        if (!produtoService.existsById(id)) {
            throw new RuntimeException("id inexistente");
        }
        return ResponseEntity.ok().body(
                new ProdutoResponseDto().toDto(
                        produtoService.save(dto.toModel(id))
                )
        );

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!produtoService.existsById(id)) {
            new RuntimeException("id inexistente");
        }
        produtoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(
                produtoService.findById(id).map(
                        e -> new ProdutoResponseDto().toDto(e)
                ).orElseThrow(() -> new RuntimeException("id inexistente"))
        );
    }
}
