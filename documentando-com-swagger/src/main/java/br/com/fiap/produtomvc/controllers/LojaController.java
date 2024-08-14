package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.dto.LojaDTO;
import br.com.fiap.produtomvc.services.LojaService;
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
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaService service;

    @Operation(
            description = "Lista Lojas",
            summary = "Retorna lista de lojas",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400")
                    //@ApiResponse(description = "Unauthorized", responseCode = "401")
                    //@ApiResponse(description = "Forbidden", responseCode = "403")
                    //@ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<LojaDTO>> findAll(){
        List<LojaDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Encontra uma loja existente pelo identificador {id}",
            summary = "Retorna uma loja por id",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400")
                    //@ApiResponse(description = "Unauthorized", responseCode = "401")
                    //@ApiResponse(description = "Forbidden", responseCode = "403")
                    //@ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<LojaDTO> findById(@PathVariable Long id){
        LojaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Cria uma loja",
            summary = "Salva uma loja",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400")
                    //@ApiResponse(description = "Unauthorized", responseCode = "401")
                    //@ApiResponse(description = "Forbidden", responseCode = "403")
                    //@ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @PostMapping(produces = "application/json")
    public ResponseEntity<LojaDTO> insert(@RequestBody @Valid LojaDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(
            description = "Atualiza uma loja existente pelo identificador {id}",
            summary = "Atualiza uma loja por id",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400")
                    //@ApiResponse(description = "Unauthorized", responseCode = "401")
                    //@ApiResponse(description = "Forbidden", responseCode = "403")
                    //@ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<LojaDTO> update(@PathVariable Long id,
                                               @RequestBody @Valid LojaDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }


    @Operation(
            description = "Deleta uma loja existente pelo identificador {id}",
            summary = "Deleta uma loja por id",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400")
                    //@ApiResponse(description = "Unauthorized", responseCode = "401")
                    //@ApiResponse(description = "Forbidden", responseCode = "403")
                    //@ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}









