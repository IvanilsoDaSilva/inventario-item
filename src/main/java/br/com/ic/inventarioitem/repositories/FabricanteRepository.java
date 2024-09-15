package br.com.ic.inventarioitem.repositories;

import br.com.ic.inventarioitem.entities.core.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, String> {
    @Query(value = "SELECT * FROM fabricante WHERE razao_social = :razaoSocial", nativeQuery = true)
    Fabricante findByRazaoSocial(String razaoSocial);
}
