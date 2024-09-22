package br.com.ic.inventarioitem.service;

import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.repositories.UsuarioRepository;
import br.com.ic.inventarioitem.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
public class UsuarioServiceTests {
    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;

    @Test
    void criarUsuarioSucesso() {
        Usuario mock = Usuario.builder()
                .nome("Usuario")
                .email("usuario@domain.com")
                .senha("123456768")
                .build();

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(mock);

        Usuario resultado = usuarioService.create(Usuario.builder().build());

        assertNotNull(resultado);
        assertEquals("Usuario", resultado.getNome());
        assertEquals("usuario@domain.com", resultado.getEmail());
        assertEquals("123456768", resultado.getSenha());

        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    void lerUsuarioPorEmailSucesso() {
        Usuario mock = Usuario.builder()
                .nome("Usuario")
                .email("usuario@domain.com")
                .senha("123456768")
                .build();

        when(usuarioRepository.findByEmail(any(String.class))).thenReturn(mock);

        Usuario resultado = usuarioService.readByEmail("usuario@domain.com");

        assertNotNull(resultado);
        assertEquals("Usuario", resultado.getNome());
        assertEquals("usuario@domain.com", resultado.getEmail());
        assertEquals("123456768", resultado.getSenha());

        verify(usuarioRepository, times(1)).findByEmail(any(String.class));
    }

    @Test
    void lerTodosUsuariosSucesso() {
        List<Usuario> mock = Arrays.asList(
                Usuario.builder()
                        .nome("Usuario")
                        .email("usuario@domain.com")
                        .senha("123456768")
                        .build()
        );

        when(usuarioRepository.findAll()).thenReturn(mock);

        List<Usuario> resultado = usuarioService.readAll();

        assertNotNull(resultado);
        assertEquals("Usuario", resultado.get(0).getNome());
        assertEquals("usuario@domain.com", resultado.get(0).getEmail());
        assertEquals("123456768", resultado.get(0).getSenha());

        verify(usuarioRepository, times(1)).findAll();
    }
}