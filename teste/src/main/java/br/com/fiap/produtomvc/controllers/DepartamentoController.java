package br.com.fiap.produtomvc.controllers;

import br.com.fiap.produtomvc.dto.CategoriaDTO;
import br.com.fiap.produtomvc.dto.DepartamentoDTO;
import br.com.fiap.produtomvc.services.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping("/form")
    public String loadFormDepartamento(Model model) {
        model.addAttribute("departamentoDTO", new DepartamentoDTO());
        return "departamento/novo-departamento";
    }

    @PostMapping()
    public String insert(@Valid DepartamentoDTO departamentoDTO,
                         BindingResult result,
                         RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "departamento/novo-departamento";
        }
        departamentoDTO = service.insert(departamentoDTO);
        attributes.addFlashAttribute("mensagem", "Departamento salvo com sucesso!");
        return "redirect:/departamentos";
    }

    @GetMapping()
    public String findAll(Model model) {
        List<DepartamentoDTO> departamentoDTO = service.findAll();
        System.out.println(departamentoDTO);
        model.addAttribute("departamentoDTO", departamentoDTO);
        return "/departamento/listar-departamentos";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        DepartamentoDTO departamentoDTO = service.findById(id);
        model.addAttribute("departamentoDTO", departamentoDTO);
        return "/departamento/editar-departamento";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid DepartamentoDTO departamentoDTO,
                         BindingResult result) {
        if (result.hasErrors()) {
            departamentoDTO.setId(id);
            return "/departamento/editar-departamento";
        }
        service.update(id, departamentoDTO);
        return "redirect:/departamentos";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        return "redirect:/departamentos";
    }

}
