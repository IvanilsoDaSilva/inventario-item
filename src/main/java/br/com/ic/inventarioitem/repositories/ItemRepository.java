package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.core.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    List<Item> findByFabricanteId(String fabricanteId);
    List<Item> findByFornecedorId(String fornecedorId);
    List<Item> findByProprietarioId(String proprietarioId);
    List<Item> findByVendedorId(String vendedorId);
}
