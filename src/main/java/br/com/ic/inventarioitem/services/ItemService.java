package br.com.ic.inventarioitem.services;

import br.com.ic.inventarioitem.entities.core.Item;
import br.com.ic.inventarioitem.entities.core.Item;
import br.com.ic.inventarioitem.repositories.ItemRepository;
import br.com.ic.inventarioitem.repositories.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository repository;

    public Item create(Item Item){
        return repository.save(Item);
    }

    public Item readByNome(String nome){
        return repository.findByNome(nome);
    }

    public List<Item> readAll(){
        return repository.findAll();
    }
    
    public void delete(String id) {
    	repository.deleteById(id);
	}
    
    public Item update(Item item) {
    	return repository.save(item);
    }

    public void delete(Item item){
    	repository.delete(item);
    }
}
