package br.com.ic.inventarioitem.entities.business;

import br.com.ic.inventarioitem.entities.abstracts.PessoaJuridica;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "fabricante")
@Data
@SuperBuilder
@NoArgsConstructor
public class Fabricante extends PessoaJuridica {
    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "site", length = 100, unique = true)
    private String site;
}
