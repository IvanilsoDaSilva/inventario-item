package br.com.ic.inventarioitem.controllers;

import br.com.ic.inventarioitem.services.autorizacao.AutorizacaoService;
import br.com.ic.inventarioitem.services.autorizacao.loginstrategy.LoginEmailSenhaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class AutorizacaoController {
    @Autowired
    private AutorizacaoService autorizacaoService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String login() { return "login";}

    @CrossOrigin // Permite solicitações de outros dominios
    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity loginEmailSenha(@RequestBody @Valid String request) {
        var autenticacao = autorizacaoService.login(request, new LoginEmailSenhaService());

        return ResponseEntity.ok().build();
    }
}
