package br.com.ic.inventarioitem.controllers.view;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.com.ic.inventarioitem.entities.core.Fabricante;
import br.com.ic.inventarioitem.services.FabricanteService;

@Controller
@RequestMapping("operador/fabricantes")
public class FabricanteViewController {
	@Autowired
    FabricanteService service;
	
    @GetMapping("")
    public String readPage(Model model) {
        model.addAttribute("fabricantes", service.readAll());
        return "operador/fabricante/read"; // Retorne a página Thymeleaf
    }

    @PostMapping("/novo")
    public String create(@Valid @ModelAttribute Fabricante fabricante, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "operador/fabricante/create";
        }

        service.create(fabricante);
        return "redirect:/operador/fabricantes";
    }
    
    @GetMapping("/novo")
    public String createPage(Model model) {
    	model.addAttribute("fabricante", new Fabricante());
        return "operador/fabricante/create"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/deletar/{id}")
    public String delete(@PathVariable String id, Model model) {
        service.delete(id);
        return "redirect:/operador/fabricantes";
    }

    @GetMapping("/deletar/{id}")
    public String deletePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(fabricante -> model.addAttribute("fabricante", fabricante));
        return "operador/fabricante/delete"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/atualizar")
    public String update(@Valid @ModelAttribute Fabricante fabricante, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "operador/fabricante/update";
        }

        service.update(fabricante);
        return "redirect:/operador/fabricantes";
    }

    @GetMapping("/atualizar/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(fabricante -> model.addAttribute("fabricante", fabricante));
        return "operador/fabricante/update"; // Retorne a página Thymeleaf com a lista atualizada
    }
}
