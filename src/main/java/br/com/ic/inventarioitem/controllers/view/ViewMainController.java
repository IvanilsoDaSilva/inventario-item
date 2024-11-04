package br.com.ic.inventarioitem.controllers.view;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ViewMainController {
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        return "index";
    }

    @GetMapping("/administrador")
    @ResponseStatus(HttpStatus.OK)
    public String administradorDashboard() {
        return "administrador/dashboard";
    }

    @GetMapping("/operador")
    @ResponseStatus(HttpStatus.OK)
    public String operadorDashboard() {
        return "operador/dashboard";
    }
}
