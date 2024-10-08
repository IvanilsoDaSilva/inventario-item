package br.com.ic.inventarioitem.services;

import br.com.ic.inventarioitem.entities.core.Vendedor;
import br.com.ic.inventarioitem.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {
    @Autowired
    VendedorRepository repository;

    public Vendedor create(Vendedor vendedor){
        return repository.save(vendedor);
    }

    public Vendedor readByRazaoSocial(String razaoSocial){
        return repository.findByRazaoSocial(razaoSocial);
    }

    public List<Vendedor> readAll(){
        return repository.findAll();
    }
    
    public void delete(String id) {
    	repository.deleteById(id);
	}
    
    public Vendedor update(Vendedor vendedor) {
    	return repository.save(vendedor);
    }
}
