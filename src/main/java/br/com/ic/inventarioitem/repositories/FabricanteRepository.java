package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.core.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, String> {
}
