package br.com.ic.inventarioitem.controllers.view;

import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("administrador/usuarios")
public class UsuarioViewController {
	@Autowired
    UsuarioService service;
	
    @GetMapping("")
    public String readPage(Model model) {
        model.addAttribute("usuarios", service.readAll());
        return "administrador/usuario/read"; // Retorne a página Thymeleaf
    }

    @PostMapping("/novo")
    public String create(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "administrador/usuario/create";
        }

        service.create(usuario);
        return "redirect:/administrador/usuarios";
    }
    
    @GetMapping("/novo")
    public String createPage(Model model) {
    	model.addAttribute("usuario", new Usuario());
        return "administrador/usuario/create"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/deletar/{id}")
    public String delete(@PathVariable String id, Model model) {
        service.delete(id);
        return "redirect:/administrador/usuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(usuario -> model.addAttribute("usuario", usuario));
        return "administrador/usuario/delete"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/atualizar")
    public String update(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "administrador/usuario/update";
        }

        service.update(usuario);
        return "redirect:/administrador/usuarios";
    }

    @GetMapping("/atualizar/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(usuario -> model.addAttribute("usuario", usuario));
        return "administrador/usuario/update"; // Retorne a página Thymeleaf com a lista atualizada
    }
}
