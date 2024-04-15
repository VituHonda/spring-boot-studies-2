package br.com.fiap.mvcusuario.controllers;

import br.com.fiap.mvcusuario.models.User;
import br.com.fiap.mvcusuario.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/form")
    public String loadForm(Model model) {
        model.addAttribute("user", new User());
        return "user/novo-user";
    }

    @PostMapping()
    //@Transactional
    public String insert(@Valid User user,
                         BindingResult result,
                         RedirectAttributes attributes) {
        if(result.hasErrors()){
            return "user/novo-user";
        }
        //repository.save(produto);
        user = service.insert(user);
        attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso");
        return "redirect:/users/form";
    }

    @GetMapping()
    //@Transactional(readOnly = true)
    public String findAll(Model model){
        //model.addAttribute("produtos", repository.findAll());
        model.addAttribute("users", service.findAll());
        return "/user/listar-users";
    }

    @GetMapping("/{id}")
    //@Transactional(readOnly = true)
    public String findById(@PathVariable("id") Long id, Model model ){

//        Produto produto = repository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("Produto inválido - id: " + id)
//        );
        User user = service.findById(id);
        model.addAttribute("user", user);
        return "/user/editar-user";
    }

    @PutMapping("/{id}")
    //@Transactional
    public String update(@PathVariable("id") Long id,
                         @Valid User user,
                         BindingResult result){
        if(result.hasErrors()){
            user.setId(id);
            return "/user/editar-user";
        }
        //repository.save(produto);
        service.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    //@Transactional
    public String delete(@PathVariable("id") Long id, Model model){
//        if(!repository.existsById(id)){
//            throw new IllegalArgumentException("Produto inválido - id: " + id);
//        }
//        try {
//            repository.deleteById(id);
//        } catch (Exception e){
//            throw new IllegalArgumentException("Produto inválido - id: " + id);
//        }
        service.delete(id);

        return "redirect:/users";
    }

}
