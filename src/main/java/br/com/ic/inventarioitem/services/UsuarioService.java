package br.com.ic.inventarioitem.services;

import br.com.ic.inventarioitem.entities.core.Usuario;
import br.com.ic.inventarioitem.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario readByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> readAll(){
        return usuarioRepository.findAll();
    }
}
