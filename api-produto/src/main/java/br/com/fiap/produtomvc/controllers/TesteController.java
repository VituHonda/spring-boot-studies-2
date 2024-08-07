package br.com.fiap.produtomvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public ResponseEntity<String> teste(@RequestParam ("teste") String teste){

        if(teste.equals("bad") ) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok("Seu teste foi: " + teste);
    }

}
