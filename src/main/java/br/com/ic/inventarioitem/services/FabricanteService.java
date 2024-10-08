package br.com.ic.inventarioitem.services;

import br.com.ic.inventarioitem.entities.core.Fabricante;
import br.com.ic.inventarioitem.repositories.FabricanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService {
    @Autowired
    FabricanteRepository repository;

    public Fabricante create(Fabricante fabricante){
        return repository.save(fabricante);
    }

    public Fabricante readByRazaoSocial(String razaoSocial){
        return repository.findByRazaoSocial(razaoSocial);
    }

    public List<Fabricante> readAll(){
        return repository.findAll();
    }
    
    public void delete(String id) {
    	repository.deleteById(id);
	}
    
    public Fabricante update(Fabricante fabricante) {
    	return repository.save(fabricante);
    }
}
