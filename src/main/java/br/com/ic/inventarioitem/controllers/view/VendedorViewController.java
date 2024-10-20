package br.com.ic.inventarioitem.controllers.view;

import br.com.ic.inventarioitem.entities.core.Vendedor;
import br.com.ic.inventarioitem.enums.TipoLoja;
import br.com.ic.inventarioitem.services.VendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("operador/vendedores")
public class VendedorViewController {
	@Autowired
    VendedorService service;
	
    @GetMapping("")
    public String readPage(Model model) {
        model.addAttribute("vendedores", service.readAll());
        return "operador/vendedor/read"; // Retorne a página Thymeleaf
    }

    @PostMapping("/novo")
    public String create(@Valid @ModelAttribute Vendedor vendedor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "operador/vendedor/create";
        }

        service.create(vendedor);
        return "redirect:/operador/vendedores";
    }
    
    @GetMapping("/novo")
    public String createPage(Model model) {
        model.addAttribute("tiposLoja", Arrays.stream(TipoLoja.values()).toList());
    	model.addAttribute("vendedor", new Vendedor());
        return "operador/vendedor/create"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/deletar/{id}")
    public String delete(@PathVariable String id, Model model) {
        service.delete(id);
        return "redirect:/operador/vendedores";
    }

    @GetMapping("/deletar/{id}")
    public String deletePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(vendedor -> model.addAttribute("vendedor", vendedor));
        return "operador/vendedor/delete"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/atualizar")
    public String update(@Valid @ModelAttribute Vendedor vendedor, BindingResult result, Model model) {
        System.out.println(vendedor.getRazaoSocial());
        System.out.println(vendedor.getTelefone());
        System.out.println(vendedor.getSite());

        if (result.hasErrors()) {
            return "operador/vendedor/update";
        }

        service.update(vendedor);
        return "redirect:/operador/vendedores";
    }

    @GetMapping("/atualizar/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        model.addAttribute("tiposLoja", Arrays.stream(TipoLoja.values()).toList());
        service.readById(id).ifPresent(vendedor -> model.addAttribute("vendedor", vendedor));
        return "operador/vendedor/update"; // Retorne a página Thymeleaf com a lista atualizada
    }
}
