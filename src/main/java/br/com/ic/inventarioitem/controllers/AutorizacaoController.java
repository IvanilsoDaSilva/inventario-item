package br.com.ic.inventarioitem.controllers;

import br.com.ic.inventarioitem.dto.AutenticacaoEmailSenhaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class AutorizacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity loginEmailSenha(@RequestBody AutenticacaoEmailSenhaDTO request) {

        var autenticacaoToken = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        var autenticacao = authenticationManager.authenticate(autenticacaoToken);

        return ResponseEntity.ok().build();
    }
}
