package br.com.ic.inventarioitem.services.autorizacao;

import br.com.ic.inventarioitem.dto.AutenticacaoEmailSenhaDTO;
import br.com.ic.inventarioitem.repositories.UsuarioRepository;
import br.com.ic.inventarioitem.services.autorizacao.loginstrategy.LoginStrategyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutorizacaoService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email);
    }

    /**
     * Realiza o processo de autenticação usando a estratégia de login fornecida.
     *
     * Este método utiliza o padrão de design Strategy para permitir a flexibilidade na escolha
     * do método de autenticação.
     *
     * O método `login` aceita uma string `request` contendo os dados necessários para autenticação
     * e um objeto `LoginStrategyService` que representa a estratégia de login a ser utilizada.
     * O `LoginStrategyService` deve implementar uma interface ou classe abstrata comum que define
     * o método `login`. Dependendo da implementação concreta de `LoginStrategyService`, o método
     * `login` será capaz de autenticar o usuário de diferentes maneiras (por exemplo, autenticação
     * por e-mail e senha, autenticação via token, etc.).
     *
     * @param request Uma string contendo os dados necessários para autenticação (por exemplo, JSON com
     *                informações de login).
     * @param loginStrategy A estratégia de login a ser utilizada, que deve implementar uma interface ou
     *                      classe abstrata comum com o método `login`.
     * @return Um objeto `Authentication` que representa o resultado da autenticação.
     * @throws JsonProcessingException Se ocorrer um erro ao processar a string JSON da solicitação.
     */
    public Authentication login(String request, LoginStrategyService loginStrategy) throws JsonProcessingException {
        return loginStrategy.login(request);
    }
}
