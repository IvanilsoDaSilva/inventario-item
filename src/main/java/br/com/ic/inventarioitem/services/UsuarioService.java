package br.com.ic.inventarioitem.services;

import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;

    public Usuario create(Usuario usuario){
        return repository.save(usuario);
    }

    public Optional<Usuario> readByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

    public Optional<Usuario> readById(String id) {
        return repository.findById(id);
    }

    public List<Usuario> readAll(){
        return repository.findAll();
    }
    
    public void delete(String id) {
    	repository.deleteById(id);
	}
    
    public Usuario update(Usuario usuario) {
    	return repository.save(usuario);
    }
}
