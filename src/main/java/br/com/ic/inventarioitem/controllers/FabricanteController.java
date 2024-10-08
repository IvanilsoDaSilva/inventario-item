package br.com.ic.inventarioitem.controllers;

import br.com.ic.inventarioitem.entities.core.Fabricante;
import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.services.FabricanteService;
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
@RequestMapping("api/v1/fabricante")
public class FabricanteController {
    @Autowired
    FabricanteService service;

    @Operation(summary = "Cria um fabricante")
    @ApiResponses(value={
    	    @ApiResponse(
    	        responseCode = "201", description = "Fabricante criado",
    	        content = { @Content(mediaType = "application/json",
    	        schema = @Schema(implementation = Usuario.class)) }),
    	    @ApiResponse(
    	        responseCode = "400",
    	        description = "Informações inválidas",
    	        content = @Content)
    	})
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Fabricante create(
            @RequestBody Fabricante body,
            @RequestHeader Map<String, String> headers
    ) {
        return service.create(body);
    }

    @Operation(summary = "Localiza um fabricante pela sua razao social")
    @ApiResponses(value={
        @ApiResponse(
            responseCode = "200", description = "Fabricante encontrado",
            content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Usuario.class)) }),
        @ApiResponse(
            responseCode = "400",
            description = "Informações inválidas",
            content = @Content),
        @ApiResponse(
            responseCode = "404",
            description = "Fabricante não encontrado",
            content = @Content)
    })
    @GetMapping("/read-by-razao-social/{razao-social}")
    @ResponseStatus(HttpStatus.OK)
    public Fabricante readByEmail(
            @PathVariable String razaoSocial,
            @RequestHeader Map<String, String> headers
    ) {
        return service.readByRazaoSocial(razaoSocial);
    }


    @Operation(summary = "Localiza todos os fabricantes")
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
    public List<Fabricante> readAll(
            @RequestHeader Map<String, String> headers
    ) {
        return service.readAll();
    }

    @Operation(summary = "Atualiza um fabricante")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "200", description = "Fabricante atualizado",
          content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Usuario.class)) }),
      @ApiResponse(
          responseCode = "400",
          description = "Informações inválidas",
          content = @Content)
    })
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Fabricante update(
            @RequestBody Fabricante body,
            @RequestHeader Map<String, String> headers
    ) {
        return service.update(body);
    }

    @Operation(summary = "Deleta um fabricante")
    @ApiResponses(value={ 
      @ApiResponse(
          responseCode = "204", description = "Fabricante deletado",
          content = { @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Usuario.class)) }),
      @ApiResponse(
          responseCode = "404",
          description = "Fabricante não encontrado",
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
