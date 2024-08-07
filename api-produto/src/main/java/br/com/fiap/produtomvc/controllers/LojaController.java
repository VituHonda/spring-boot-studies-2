package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.services.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaService service;

    

}
