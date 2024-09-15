package br.com.ic.inventarioitem.runners;

import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.enums.PapeisUsuario;
import br.com.ic.inventarioitem.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class BancoDadosRunner implements ApplicationRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        usuarioRepository.save(Usuario.builder()
                .nome("Administrador")
                .email("administrador@domain.com")
//                .cpf("433.542.978-01") // Devido a validação, apenas aceita cpfs corretos ou nulos
                .senha(passwordEncoder.encode("12345678"))
                .papel(PapeisUsuario.ADMINISTRADOR)
                .build());
        usuarioRepository.save(Usuario.builder()
                .nome("Usuario")
                .email("usuario@domain.com")
//                .cpf("433.542.978-01") // Devido a validação, apenas aceita cpfs corretos ou nulos
                .senha(passwordEncoder.encode("12345678"))
                .papel(PapeisUsuario.USUARIO)
                .build());
    }
}