package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.core.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    UserDetails findByEmail(String email);

    @Query(value = "SELECT * FROM usuario WHERE cpf = :cpf", nativeQuery = true)
    Usuario findByCpf(String cpf);
}
