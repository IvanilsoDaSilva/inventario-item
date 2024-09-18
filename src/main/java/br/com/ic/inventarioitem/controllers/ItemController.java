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

    @PostMapping("/criar-um")
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(
            @RequestBody Item body,
            @RequestHeader Map<String, String> headers
    ) {
        return itemService.create(body);
    }

    @PostMapping("/ler-um-por-nome")
    @ResponseStatus(HttpStatus.OK)
    public Item readItemByName(
            @RequestBody String body,
            @RequestHeader Map<String, String> headers
    ) {

        return itemService.readByNome(body);
    }

    @GetMapping("/ler-varios")
    @ResponseStatus(HttpStatus.OK)
    public List<Item> readAll(
            @RequestHeader Map<String, String> headers
    ) {
        return itemService.readAll();
    }

    @PostMapping("/atualizar-um")
    @ResponseStatus(HttpStatus.OK)
    public String update() {
        return null;
    }

    @PostMapping("/deletar-um")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete() {
        return null;
    }
}
