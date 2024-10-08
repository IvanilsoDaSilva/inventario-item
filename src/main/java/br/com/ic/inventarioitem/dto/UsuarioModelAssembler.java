package br.com.ic.inventarioitem.dto;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import br.com.ic.inventarioitem.controllers.UsuarioController;
import br.com.ic.inventarioitem.entities.core.Usuario;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//public class UsuarioModelAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>> {
//
//    @Override
//    public EntityModel<Usuario> toModel(Usuario usuario) {
//        return EntityModel.of(usuario,
//            linkTo(methodOn(UsuarioController.class).umUsuario(usuario.getId())).withSelfRel(),
//            linkTo(methodOn(UsuarioController.class).todosUsuarios()).withRel("usuarios"));
//    }
//}
