package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.dto.*;
import br.com.fiap.produtomvc.services.DepartamentoService;
import br.com.fiap.produtomvc.services.EmpregadoService;
import br.com.fiap.produtomvc.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/empregados")
public class EmpregadoController
{

    @Autowired
    private EmpregadoService service;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private ProjetoService projetoService;

    @ModelAttribute("projetos")
    public List<ProjetoDTO> projetos(){
        return projetoService.findAll();
    }

    @ModelAttribute("departamentos")
    public List<DepartamentoDTO> departamentos() {
        return departamentoService.findAll();
    }

    @GetMapping("/form")
    public String loadForm(Model model) {
        model.addAttribute("empregadoDTO", new EmpregadoDTO());
        return "empregado/novo-empregado";
    }

}
