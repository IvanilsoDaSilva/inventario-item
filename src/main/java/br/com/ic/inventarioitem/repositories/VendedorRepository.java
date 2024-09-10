package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.business.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, String> {
}
