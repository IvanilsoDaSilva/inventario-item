package br.com.ic.inventarioitem.services;

import br.com.ic.inventarioitem.entities.core.Proprietario;
import br.com.ic.inventarioitem.repositories.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioService {
    @Autowired
    ProprietarioRepository repository;

    public Proprietario create(Proprietario proprietario){
        return repository.save(proprietario);
    }

    public Proprietario readByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

    public Optional<Proprietario> readById(String id) {
        return repository.findById(id);
    }

    public List<Proprietario> readAll(){
        return repository.findAll();
    }
    
    public void delete(String id) {
    	repository.deleteById(id);
	}
    
    public Proprietario update(Proprietario proprietario) {
    	return repository.save(proprietario);
    }
}
