package br.com.ic.inventarioitem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String login() { return "administrador/dashboard";}
}
