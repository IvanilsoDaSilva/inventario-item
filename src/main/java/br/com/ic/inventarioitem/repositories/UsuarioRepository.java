package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.core.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    @Query(value = "SELECT * FROM usuario WHERE email = :email", nativeQuery = true)
    Usuario findByEmail(String email);

    @Query(value = "SELECT * FROM usuario WHERE cpf = :cpf", nativeQuery = true)
    Usuario findByCpf(String cpf);
}
