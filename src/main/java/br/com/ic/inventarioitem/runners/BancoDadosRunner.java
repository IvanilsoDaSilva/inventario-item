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
    private final UsuarioRepository usuarioRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void run(ApplicationArguments args) {
        usuarioRepository.save(Usuario.builder()
                        .nome("Administrador")
                        .cpf("0000000000")
                        .email("administrador@domain")
                        .senha(passwordEncoder.encode("12345678"))
                        .papel(PapeisUsuario.USUARIO_ADMINISTRADOR)
                        .build());
    }
}