package br.com.ic.inventarioitem.services;

import br.com.ic.inventarioitem.entities.core.Fornecedor;
import br.com.ic.inventarioitem.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    FornecedorRepository repository;

    public Fornecedor create(Fornecedor fornecedor){
        return repository.save(fornecedor);
    }

    public Fornecedor readByRazaoSocial(String razaoSocial){
        return repository.findByRazaoSocial(razaoSocial);
    }

    public Optional<Fornecedor> readById(String id) {
        return repository.findById(id);
    }

    public List<Fornecedor> readAll(){
        return repository.findAll();
    }
    
    public void delete(String id) {
    	repository.deleteById(id);
	}
    
    public Fornecedor update(Fornecedor fornecedor) {
    	return repository.save(fornecedor);
    }
}
