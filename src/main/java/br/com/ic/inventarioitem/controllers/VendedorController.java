package br.com.ic.inventarioitem.controllers;

import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.entities.core.Vendedor;
import br.com.ic.inventarioitem.services.VendedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/vendedor")
public class VendedorController {
    @Autowired
    VendedorService service;

    @Operation(summary = "Cria um vendedor")
    @ApiResponses(value={
    	    @ApiResponse(
    	        responseCode = "201", description = "Vendedor criado",
    	        content = { @Content(mediaType = "application/json",
    	        schema = @Schema(implementation = Usuario.class)) }),
    	    @ApiResponse(
    	        responseCode = "400",
    	        description = "Informações inválidas",
    	        content = @Content)
    	})
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Vendedor create(
            @RequestBody Vendedor body,
            @RequestHeader Map<String, String> headers
    ) {
        return service.create(body);
    }

    @Operation(summary = "Localiza um vendedor pela sua razao social")
    @ApiResponses(value={
        @ApiResponse(
            responseCode = "200", description = "Vendedor encontrado",
            content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Usuario.class)) }),
        @ApiResponse(
            responseCode = "400",
            description = "Informações inválidas",
            content = @Content),
        @ApiResponse(
            responseCode = "404",
            description = "Vendedor não encontrado",
            content = @Content)
    })
    @GetMapping("/read-by-razao-social/{razao-social}")
    @ResponseStatus(HttpStatus.OK)
    public Vendedor readByEmail(
            @PathVariable String razaoSocial,
            @RequestHeader Map<String, String> headers
    ) {
        return service.readByRazaoSocial(razaoSocial);
    }


    @Operation(summary = "Localiza todos os vendedor")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "200",
          description = "Vendedores encontrados",
          content = { @Content( mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Usuario.class)))}),
      @ApiResponse(
          responseCode = "404",
          description = "Nenhum usuário encontrado",
          content = @Content)
    })
    @GetMapping("/read-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Vendedor> readAll(
            @RequestHeader Map<String, String> headers
    ) {
        return service.readAll();
    }

    @Operation(summary = "Atualiza um vendedor")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "200", description = "Vendedor atualizado",
          content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Usuario.class)) }),
      @ApiResponse(
          responseCode = "400",
          description = "Informações inválidas",
          content = @Content)
    })
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Vendedor update(
            @RequestBody Vendedor body,
            @RequestHeader Map<String, String> headers
    ) {
        return service.update(body);
    }

    @Operation(summary = "Deleta um vendedor")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "204", description = "Usuário deletado",
          content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Usuario.class)) }),
      @ApiResponse(
          responseCode = "404",
          description = "Vendedor não encontrado",
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
