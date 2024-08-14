package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.dto.ProdutoDTO;
import br.com.fiap.produtomvc.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@Tag(name = "Produtos", description = "Controller para Produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Operation(
            description = "Lista Produtos",
            summary = "Retonar uma lista de produtos",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200")
            }
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<ProdutoDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Retorna um produto a partir do identificador (id)",
            summary = "Consulta produto por id",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "NotFound", responseCode = "404")
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
        ProdutoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Cria um novo produto",
            summary = "Salva um novo produto",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400")
                    //@ApiResponse(description = "Unauthorized", responseCode = "401")
                    //@ApiResponse(description = "Forbidden", responseCode = "403")
                    //@ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    //endpoints protegidos
    //@SecurityRequirement(name = "bearerAuth")
    @PostMapping(produces = "application/json")
    public ResponseEntity<ProdutoDTO> insert(@RequestBody @Valid ProdutoDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(
            description = "Atualiza um produto existente pelo identificador {id}",
            summary = "Atualiza um produto por id",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400")
                    //@ApiResponse(description = "Unauthorized", responseCode = "401")
                    //@ApiResponse(description = "Forbidden", responseCode = "403")
                    //@ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    //endpoints protegidos
    //@SecurityRequirement(name = "bearerAuth")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id,
                                               @RequestBody @Valid ProdutoDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            description = "Deleta um produto existente pelo identificador {id}",
            summary = "Deleta um produto por id",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Unauthorized", responseCode = "401"),
                    @ApiResponse(description = "Forbidden", responseCode = "403"),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}









