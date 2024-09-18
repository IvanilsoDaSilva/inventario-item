package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.core.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    Item findByNome(String nome);

    @Query(value = "SELECT * FROM item WHERE id_fabricante = :fabricanteId", nativeQuery = true)
    List<Item> findByFabricanteId(String fabricanteId);

    @Query(value = "SELECT * FROM item WHERE id_fornecedor = :fornecedorId", nativeQuery = true)
    List<Item> findByFornecedorId(String fornecedorId);

    @Query(value = "SELECT * FROM item WHERE id_proprietario = :proprietarioId", nativeQuery = true)
    List<Item> findByProprietarioId(String proprietarioId);

    @Query(value = "SELECT * FROM item WHERE id_vendedor = :vendedorId", nativeQuery = true)
    List<Item> findByVendedorId(String vendedorId);
}
