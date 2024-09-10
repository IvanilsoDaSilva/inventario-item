package br.com.ic.inventarioitem.controllers;

import br.com.ic.inventarioitem.services.autorizacao.AutorizacaoService;
import br.com.ic.inventarioitem.services.autorizacao.loginstrategy.LoginEmailSenhaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AutorizacaoController {
    @Autowired
    private AutorizacaoService autorizacaoService;

    @GetMapping("")
    public String login() {
        return "login";
    }

    @PostMapping("")
    public ResponseEntity loginEmailSenha(@RequestBody String request) throws JsonProcessingException {

        var autenticacao = autorizacaoService.login(request, new LoginEmailSenhaService());

        return ResponseEntity.ok().build();
    }
}
