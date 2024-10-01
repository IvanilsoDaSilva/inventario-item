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

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(
            @RequestBody Usuario body,
            @RequestHeader Map<String, String> headers
    ) {
        return usuarioService.create(body);
    }

    @PostMapping("/read-by-email")
    @ResponseStatus(HttpStatus.OK)
    public Usuario readByEmail(
            @RequestBody String body,
            @RequestHeader Map<String, String> headers
    ) {
        return usuarioService.readByEmail(body);
    }

    @GetMapping("/read-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> readAll(
            @RequestHeader Map<String, String> headers
    ) {
        return usuarioService.readAll();
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String update() {
        return null; // Implementar lógica de atualização
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete() {
        return null; // Implementar lógica de exclusão
    }
}
