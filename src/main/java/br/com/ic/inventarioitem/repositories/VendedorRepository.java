package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.core.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, String> {
    @Query(value = "SELECT * FROM vendedor WHERE razao_social = :razaoSocial", nativeQuery = true)
    Vendedor findByRazaoSocial(String razaoSocial);
}
