package br.com.fiap.mvcusuario.controllers;

import br.com.fiap.mvcusuario.dto.UserDTO;
import br.com.fiap.mvcusuario.dto.UserMinDTO;
import br.com.fiap.mvcusuario.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

   @Autowired
   private UserService service;

    @GetMapping("/form")
    public String loadForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "usuarios/novo-usuario";
    }

    @PostMapping()
    public String insert(@Valid UserDTO userDTO,
                         BindingResult result,
                         RedirectAttributes attributes) {
        if(result.hasErrors()){
            return "usuarios/novo-usuario";
        }
        userDTO = service.insert(userDTO);
        attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso");
        return "redirect:/users/form";
    }

    @GetMapping()
    public String findAll(Model model){
        model.addAttribute("usersDTO", service.findAll());
        return "/usuarios/listar-usuarios";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model ){
        UserDTO userDTO = service.findById(id);
        model.addAttribute("userDTO", userDTO);
        return "/usuarios/editar-usuario";
    }


    @GetMapping("/save/{id}")
    public String findMinById(@PathVariable("id") Long id, Model model){
        UserMinDTO userMinDTO = service.findMinById(id);
        model.addAttribute("userMinDTO", userMinDTO);
        return "/usuarios/editar-senha-usuario";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid UserDTO userDTO,
                         BindingResult result){
        if(result.hasErrors()){
            userDTO.setId(id);
            return "/usuarios/editar-usuario";
        }
        service.updateDTO(id,userDTO);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid UserMinDTO userMinDTO,
                         BindingResult result){
        if(result.hasErrors()){
            userMinDTO.setId(id);
            return "/usuarios/editar-senha-usuario";
        }
        service.updateMin(id, userMinDTO);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/users";
    }
}
