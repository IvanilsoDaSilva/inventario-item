package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.core.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
}
