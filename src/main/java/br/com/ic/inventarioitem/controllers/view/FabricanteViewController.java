package br.com.ic.inventarioitem.controllers.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.ic.inventarioitem.entities.core.Fabricante;
import br.com.ic.inventarioitem.services.FabricanteService;

@Controller
@RequestMapping("operador/fabricantes")
public class FabricanteViewController {
	@Autowired
    FabricanteService service;
	
    @GetMapping("")
    public String read(Model model) {
        List<Fabricante> fabricantes = service.readAll(); // Chame o método que lista os fabricantes
        model.addAttribute("fabricantes", fabricantes); // Adicione os dados ao modelo
        return "operador/fabricante/read"; // Retorne a página Thymeleaf
    }
    
    @GetMapping("/new")
    public String create(Model model) {
    	model.addAttribute("fabricante", new Fabricante());
        return "operador/fabricante/create"; // Retorne a página Thymeleaf com a lista atualizada
    }
}
