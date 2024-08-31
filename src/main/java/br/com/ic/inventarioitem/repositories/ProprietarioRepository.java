package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.business.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, String> {
}
