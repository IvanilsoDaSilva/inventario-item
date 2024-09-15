package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.core.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, String> {
    @Query(value = "SELECT * FROM proprietario WHERE cpf = :cpf", nativeQuery = true)
    Proprietario findByCpf(String cpf);
}
