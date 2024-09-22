package br.com.ic.inventarioitem.services;

import br.com.ic.inventarioitem.entities.core.Item;
import br.com.ic.inventarioitem.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Item create(Item item){
        return itemRepository.save(item);
    }

    public Item readByNome(String nome){
        return itemRepository.findByNome(nome);
    }

    public List<Item> readAll(){
        return itemRepository.findAll();
    }

    public void delete(Item item){
        itemRepository.delete(item);
    }
}
