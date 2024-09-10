package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaFisica;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

// PErsistencia
@Entity
@Table(name = "proprietario")
//@DiscriminatorValue("PROPRIETARIO")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public class Proprietario extends PessoaFisica {
    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "cargo", length = 100)
    private String cargo;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    protected List<Item> items;
}
