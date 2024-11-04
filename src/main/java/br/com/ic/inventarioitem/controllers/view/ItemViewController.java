package br.com.ic.inventarioitem.controllers.view;

import br.com.ic.inventarioitem.entities.core.Item;
import br.com.ic.inventarioitem.enums.CategoriaItem;
import br.com.ic.inventarioitem.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("operador/itens")
public class ItemViewController {
	@Autowired
    ItemService service;
    @Autowired
    FabricanteService serviceFabricantes;
    @Autowired
    FornecedorService fornecedorService;
    @Autowired
    VendedorService vendedorService;
    @Autowired
    ProprietarioService proprietarioService;

	
    @GetMapping("")
    public String readPage(Model model) {
        model.addAttribute("itens", service.readAll());
        return "operador/item/read"; // Retorne a página Thymeleaf
    }

    @PostMapping("/novo")
    public String create(@Valid @ModelAttribute Item item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "operador/item/create";
        }

        service.create(item);
        return "redirect:/operador/itens";
    }
    
    @GetMapping("/novo")
    public String createPage(Model model) {
        model.addAttribute("categorias", Arrays.stream(CategoriaItem.values()).toList());
        model.addAttribute("fabricantes", serviceFabricantes.readAll());
        model.addAttribute("fornecedores", fornecedorService.readAll());
        model.addAttribute("vendedores", vendedorService.readAll());
        model.addAttribute("proprietarios", proprietarioService.readAll());
        model.addAttribute("item", new Item());
        return "operador/item/create"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/deletar/{id}")
    public String delete(@PathVariable String id, Model model) {
        service.delete(id);
        return "redirect:/operador/itens";
    }

    @GetMapping("/deletar/{id}")
    public String deletePage(@PathVariable String id, Model model) {
        service.readById(id).ifPresent(item -> model.addAttribute("item", item));
        return "operador/item/delete"; // Retorne a página Thymeleaf com a lista atualizada
    }

    @PostMapping("/atualizar")
    public String update(@Valid @ModelAttribute Item item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "operador/item/update";
        }

        service.update(item);
        return "redirect:/operador/itens";
    }

    @GetMapping("/atualizar/{id}")
    public String updatePage(@PathVariable String id, Model model) {
        model.addAttribute("categorias", Arrays.stream(CategoriaItem.values()).toList());
        model.addAttribute("fabricantes", serviceFabricantes.readAll());
        model.addAttribute("fornecedores", fornecedorService.readAll());
        model.addAttribute("vendedores", vendedorService.readAll());
        model.addAttribute("proprietarios", proprietarioService.readAll());
        service.readById(id).ifPresent(item -> model.addAttribute("item", item));
        return "operador/item/update"; // Retorne a página Thymeleaf com a lista atualizada
    }
}
