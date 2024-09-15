package br.com.ic.inventarioitem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String login() { return "operador/dashboard";}
}
