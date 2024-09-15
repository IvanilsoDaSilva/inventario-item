package br.com.ic.inventarioitem;

import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.enums.PapeisUsuario;
import br.com.ic.inventarioitem.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
@AutoConfigureMockMvc
class AutorizacaoControllerTests {
	@Mock
	UsuarioRepository usuarioRepository;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext contexto;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders
				.webAppContextSetup(contexto)
				.apply(springSecurity())
				.build();
	}

	@Test
	void obterPaginaLogin() throws Exception {
		this.mockMvc.perform(get("/login")
//						.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // Sem corpo de requisicao
						.header(HttpHeaders.ACCEPT, "application/json")
//						.content("") // Sem corpo de requisicao
				)
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void obterPaginaAdministradorDeslogado() throws Exception {
		this.mockMvc.perform(get("/administrador")
//						.header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8")
						.header(HttpHeaders.ACCEPT, "application/json")
//						.content("") // Sem corpo de requisicao
				)
				.andDo(print())
				.andExpect(status().isUnauthorized());
	}

	@Test
	void obterPaginaAdministradorLogado() throws Exception {
		this.mockMvc.perform(get("/administrador")
						.header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8")
//						.header(HttpHeaders.ACCEPT, "application/json")
						.with(user("Ivanilso").authorities(new SimpleGrantedAuthority("ROLE_ADMIN")))
//						.content("") // Sem corpo de requisicao
				)
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void obterPaginaUsuarioDeslogado() throws Exception {
		this.mockMvc.perform(get("/usuario")
//						.header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8")
						.header(HttpHeaders.ACCEPT, "application/json")
//						.content("") // Sem corpo de requisicao
				)
				.andDo(print())
				.andExpect(status().isUnauthorized());
	}

	@Test
	void obterPaginaUsuarioLogado() throws Exception {
		this.mockMvc.perform(get("/usuario")
						.header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8")
//						.header(HttpHeaders.ACCEPT, "application/json")
						.with(user("Ivanilso").authorities(new SimpleGrantedAuthority("ROLE_USER")))
//						.content("") // Sem corpo de requisicao
				)
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void fazerLoginSucesso() throws Exception {
		Usuario mockUsuario = Usuario.builder()
				.nome("Ivanilso da Silva")
				.email("ivanilso.silva@domain.com")
				.senha(passwordEncoder.encode("12345678"))
				.papel(PapeisUsuario.ADMINISTRADOR)
				.build();

		when(usuarioRepository.findByEmail("ivanilso.silva@domain.com")).thenReturn(mockUsuario);

		this.mockMvc.perform(post("/login")
							.header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8")
							.header(HttpHeaders.ACCEPT, "application/json")
							.content("""
								{
									"username": "administrador@domain.com",
									"password": "12345678"
								}
							""")
						)
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(header().string(HttpHeaders.LOCATION, "/"));
	}

	@Test
	void fazerLoginFalha() throws Exception {
		// Cria um usuário mock com a senha criptografada
		Usuario mockUsuario = Usuario.builder()
				.nome("Ivanilso da Silva")
				.email("ivanilso.silva@domain.com")
				.senha(passwordEncoder.encode("12345678"))
				.papel(PapeisUsuario.ADMINISTRADOR)
				.build();

		// Configura o mock para retornar o usuário quando buscar pelo e-mail
		when(usuarioRepository.findByEmail("ivanilso.silva@domain.com")).thenReturn(mockUsuario);

		// Realiza o POST no endpoint de login
		this.mockMvc.perform(post("/login")
						.header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8")
						.header(HttpHeaders.ACCEPT, "application/json")
						.content("""
                			{
                    			"username": "ivanilso.silva@domain.com",
                    			"password": "1234567"
                			}
            			""")
				)
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(header().string(HttpHeaders.LOCATION, "/login?error"));
	}
}
