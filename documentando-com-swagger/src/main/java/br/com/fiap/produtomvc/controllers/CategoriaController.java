package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.dto.CategoriaDTO;
import br.com.fiap.produtomvc.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Operation(
            description = "Lista de categorias",
            summary = "Retorna uma lista de categorias",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "NotFound", responseCode = "404")
            }
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<CategoriaDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Retorna uma categoria a partir do identificador (id)",
            summary = "Consulta categoria por id",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "NotFound", responseCode = "404")
            }
    )
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id){
        CategoriaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Cria uma nova categoria",
            summary = "Salva uma nova categoria",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "NotFound", responseCode = "404")
            }
    )
    @PostMapping(produces = "application/json")
    public ResponseEntity<CategoriaDTO> insert(@RequestBody @Valid CategoriaDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(
            description = "Atualiza uma categoria a partir do identificador (id)",
            summary = "Atualiza categoria por id",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "NotFound", responseCode = "404")
            }
    )
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id,
                                               @RequestBody @Valid CategoriaDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Deleta um produto a partir do identificador (id)",
            summary = "Deleta produto por id",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "NotFound", responseCode = "404")
            }
    )
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}









