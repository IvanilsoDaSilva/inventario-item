package br.com.ic.inventarioitem.controllers;

import br.com.ic.inventarioitem.entities.core.Item;
import br.com.ic.inventarioitem.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    
    @Operation(summary = "Cria um item")
    @ApiResponses(value={ 
      @ApiResponse(
    		  responseCode = "201",
              description = "Item criado",
    		  content = { @Content(mediaType = "application/json",
    		  schema = @Schema(implementation = Item.class)) }),
      @ApiResponse(
    		  responseCode = "400",
    		  description = "Informações inválidas",
    		  content = @Content)
    })
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(
            @RequestBody Item body,
            @RequestHeader Map<String, String> headers
    ) {
        return itemService.create(body);
    }

    @Operation(summary = "Localiza um item pelo seu nome")
    @ApiResponses(value={ 
      @ApiResponse(
    		  responseCode = "201",
    		  description = "Item encontrado",
    		  content = { @Content(mediaType = "application/json",
    		  schema = @Schema(implementation = Item.class)) }),
      @ApiResponse(
    		  responseCode = "400",
    		  description = "Informações invalidas",
    		  content = @Content),
      @ApiResponse(
    		  responseCode = "404",
    		  description = "Item não encontrado",
    		  content = @Content)
    })
    @PostMapping("/read-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Item readByName(
            @RequestBody String body,
            @RequestHeader Map<String, String> headers
    ) {

        return itemService.readByNome(body);
    }

    @Operation(summary = "Localiza todos itens")
    @ApiResponses(value={ 
      @ApiResponse(
    		  responseCode = "201",
    		  description = "Itens encontrado", 
    		  content = { @Content( mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Item.class)))}),
      @ApiResponse(
    		  responseCode = "404",
    		  description = "Itens não encontrado", 
    		  content = @Content)
      })
    @GetMapping("/read-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Item> readAll(
            @RequestHeader Map<String, String> headers
    ) {
        return itemService.readAll();
    }

    @Operation(summary = "Atualiza um item")
    @ApiResponses(value={ 
      @ApiResponse(
    		  responseCode = "201",
    		  description = "Itens atualizado", 
    		  content = { @Content(mediaType = "application/json", 
    		  schema = @Schema(implementation = Item.class)) }),
      @ApiResponse(
    		  responseCode = "400",
    		  description = "Informações inválidas", 
    		  content = @Content)
      })
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String update() {
        return null;
    }

    @Operation(summary = "Deleta um item pelo seu id")
    @ApiResponses(value={ 
      @ApiResponse(
    		  responseCode = "204",
    		  description = "Item deletado",
    		  content = { @Content(mediaType = "application/json",
    		  schema = @Schema(implementation = Item.class)) }),
      @ApiResponse(
    		  responseCode = "404",
    		  description = "Item não encontrado",
    		  content = @Content)
    })
    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete() {
        return null;
    }
}
