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

    @Operation(summary = "Cria um usuário")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "201", description = "Usuário criado",
          content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Usuario.class)) }),
      @ApiResponse(
          responseCode = "400",
          description = "Informações inválidas",
          content = @Content)
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(
            @RequestBody Usuario body,
            @RequestHeader Map<String, String> headers
    ) {
        return usuarioService.create(body);
    }

    @Operation(summary = "Localiza um usuário pelo seu email")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "200", description = "Usuário encontrado",
          content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Usuario.class)) }),
      @ApiResponse(
          responseCode = "400",
          description = "Informações inválidas",
          content = @Content),
      @ApiResponse(
          responseCode = "404",
          description = "Usuário não encontrado",
          content = @Content)
    })
    @PostMapping("/read-by-email")
    @ResponseStatus(HttpStatus.OK)
    public Usuario readByEmail(
            @RequestBody String body,
            @RequestHeader Map<String, String> headers
    ) {
        return usuarioService.readByEmail(body);
    }

    @Operation(summary = "Localiza todos os usuários")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "200", description = "Usuários encontrados",
          content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Usuario.class)) }),
      @ApiResponse(
          responseCode = "404",
          description = "Nenhum usuário encontrado",
          content = @Content)
    })
    @GetMapping("/read-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> readAll(
            @RequestHeader Map<String, String> headers
    ) {
        return usuarioService.readAll();
    }

    @Operation(summary = "Atualiza um usuário")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "200", description = "Usuário atualizado",
          content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Usuario.class)) }),
      @ApiResponse(
          responseCode = "400",
          description = "Informações inválidas",
          content = @Content)
    })
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String update() {
        return null; // Implementar lógica de atualização
    }

    @Operation(summary = "Deleta um usuário")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "204", description = "Usuário deletado",
          content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Usuario.class)) }),
      @ApiResponse(
          responseCode = "404",
          description = "Usuário não encontrado",
          content = @Content)
    })
    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete() {
        return null; // Implementar lógica de exclusão
    }
}
