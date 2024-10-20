package br.com.ic.inventarioitem.controllers.view;

import br.com.ic.inventarioitem.entities.core.Proprietario;
import br.com.ic.inventarioitem.services.ProprietarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("operador/proprietarios")
public class ProprietarioViewController {
	@Autowired
    ProprietarioService service;
	
    @GetMapping("")
    public String readPage(Model model) {
        model.addAttribute("proprietarios", service.readAll());
        return "operador/proprietario/read"; // Retorne a página Thymeleaf
    }

    @PostMapping("/novo")
    public String create(@Valid @ModelAttribute Proprietario proprietario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "operador/proprietario/create";
        }

        service.create(proprietario);
        return "redirect:/operador/proprietarios";
    }
    
    @GetMapping("/novo")
    public String createPage(Model model) {
    	model.addAttribute("proprietario", new Proprietario());
        return "operador/proprietario/create"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/deletar/{id}")
    public String delete(@PathVariable String id, Model model) {
        service.delete(id);
        return "redirect:/operador/proprietarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(proprietario -> model.addAttribute("proprietario", proprietario));
        return "operador/proprietario/delete"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/atualizar")
    public String update(@Valid @ModelAttribute Proprietario proprietario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "operador/proprietario/update";
        }

        service.update(proprietario);
        return "redirect:/operador/proprietarios";
    }

    @GetMapping("/atualizar/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(proprietario -> model.addAttribute("proprietario", proprietario));
        return "operador/proprietario/update"; // Retorne a página Thymeleaf com a lista atualizada
    }
}
