package br.com.ic.inventarioitem.controllers.apirest;

import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.repositories.UsuarioRepository;
import br.com.ic.inventarioitem.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService service;
//    private final UsuarioModelAssembler assembler;
    
//    public UsuarioController(UsuarioService service, UsuarioModelAssembler assembler) {
//        this.service = service;
//        this.assembler = assembler;
//    }
    
//    // Método para retornar um único funcionário
//    @GetMapping("/read-by-email/{email}")
//    public EntityModel<Usuario> umUsuario(
//    		@PathVariable String email,
//    		@RequestHeader Map<String, String> headers
//    ) {
//        Usuario usuario = service.readByEmail(email)
//            .orElseThrow(() -> new UsuarioNaoEncontradoException(email));
//
//        return assembler.toModel(usuario);
//    }
//
//    // Método para retornar todos os funcionários
//    @GetMapping("/")
//    public CollectionModel<EntityModel<Funcionario>> todosFuncionarios() {
//        List<EntityModel<Funcionario>> funcionarios = repositorio.findAll().stream()
//            .map(assembler::toModel)
//            .collect(Collectors.toList());
//
//        return CollectionModel.of(funcionarios,
//            linkTo(methodOn(FuncionarioController.class).todosFuncionarios()).withSelfRel());
//    }

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
        return service.create(body);
    }

//    @Operation(summary = "Localiza um usuário pelo seu email")
//    @ApiResponses(value={
//        @ApiResponse(
//            responseCode = "200", description = "Usuário encontrado",
//            content = { @Content(mediaType = "application/json", 
//            schema = @Schema(implementation = Usuario.class)) }),
//        @ApiResponse(
//            responseCode = "400",
//            description = "Informações inválidas",
//            content = @Content),
//        @ApiResponse(
//            responseCode = "404",
//            description = "Usuário não encontrado",
//            content = @Content)
//    })
//    @GetMapping("/read-by-email/{email}")
//    @ResponseStatus(HttpStatus.OK)
//    public Usuario readByEmail(
//            @PathVariable String email,
//            @RequestHeader Map<String, String> headers
//    ) {
//        return service.readByEmail(email);
//    }


    @Operation(summary = "Localiza todos os usuários")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "200",
          description = "Usuários encontrados",
          content = { @Content( mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Usuario.class)))}),
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
        return service.readAll();
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
    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
    		@PathVariable String id,
            @RequestHeader Map<String, String> headers
    ) {
    	service.delete(id);
    }
}
