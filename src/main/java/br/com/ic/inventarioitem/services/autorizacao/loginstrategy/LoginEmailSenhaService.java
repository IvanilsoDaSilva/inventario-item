package br.com.ic.inventarioitem.services.autorizacao.loginstrategy;

import br.com.ic.inventarioitem.dto.AutenticacaoEmailSenhaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class LoginEmailSenhaService implements LoginStrategyService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ObjectMapper objectMapper; // Para converter JSON para objeto

    @Override
    public Authentication login(String request) {
        AutenticacaoEmailSenhaDTO autenticacaoEmailSenhaDTO = null;
        try {
            autenticacaoEmailSenhaDTO = objectMapper.readValue(request, AutenticacaoEmailSenhaDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro para converter a requisição");
        }
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(
                autenticacaoEmailSenhaDTO.email(), autenticacaoEmailSenhaDTO.senha());
        return authenticationManager.authenticate(autenticacaoToken);
    }
}
