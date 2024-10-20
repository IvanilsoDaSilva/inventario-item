package br.com.ic.inventarioitem.controllers.view;

import br.com.ic.inventarioitem.entities.core.Fornecedor;
import br.com.ic.inventarioitem.services.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("operador/fornecedores")
public class ForncedorViewController {
	@Autowired
    FornecedorService service;
	
    @GetMapping("")
    public String readPage(Model model) {
        model.addAttribute("fornecedores", service.readAll());
        return "operador/fornecedor/read"; // Retorne a página Thymeleaf
    }

    @PostMapping("/novo")
    public String create(@Valid @ModelAttribute Fornecedor fornecedor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "operador/fornecedor/create";
        }

        service.create(fornecedor);
        return "redirect:/operador/fornecedores";
    }
    
    @GetMapping("/novo")
    public String createPage(Model model) {
    	model.addAttribute("fornecedor", new Fornecedor());
        return "operador/fornecedor/create"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/deletar/{id}")
    public String delete(@PathVariable String id, Model model) {
        service.delete(id);
        return "redirect:/operador/fornecedores";
    }

    @GetMapping("/deletar/{id}")
    public String deletePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(fornecedor -> model.addAttribute("fornecedor", fornecedor));
        return "operador/fornecedor/delete"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/atualizar")
    public String update(@Valid @ModelAttribute Fornecedor fornecedor, BindingResult result, Model model) {
        System.out.println(fornecedor.getRazaoSocial());
        System.out.println(fornecedor.getTelefone());
        System.out.println(fornecedor.getSite());

        if (result.hasErrors()) {
            return "operador/fornecedor/update";
        }

        service.update(fornecedor);
        return "redirect:/operador/fornecedores";
    }

    @GetMapping("/atualizar/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(fornecedor -> model.addAttribute("fornecedor", fornecedor));
        return "operador/fornecedor/update"; // Retorne a página Thymeleaf com a lista atualizada
    }
}
