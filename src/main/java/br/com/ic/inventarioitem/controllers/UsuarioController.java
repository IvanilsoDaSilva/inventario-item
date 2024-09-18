package br.com.ic.inventarioitem.controllers;

import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/criar-um")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(
            @RequestBody Usuario body,
            @RequestHeader Map<String, String> headers
    ) {
        return usuarioService.create(body);
    }

    @PostMapping("/ler-um-por-email")
    @ResponseStatus(HttpStatus.OK)
    public Usuario readByEmail(
            @RequestBody String body,
            @RequestHeader Map<String, String> headers
    ) {

        return usuarioService.readByEmail(body);
    }

    @GetMapping("/ler-varios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> readAll(
            @RequestHeader Map<String, String> headers
    ) {

        return usuarioService.readAll();
    }

//    @PostMapping("/atualizar-um")
//    @ResponseStatus(HttpStatus.OK)
//    public String update() {
//        return null;
//    }

//    @PostMapping("/deletar-um")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public String delete() {
//        return null;
//    }
}
