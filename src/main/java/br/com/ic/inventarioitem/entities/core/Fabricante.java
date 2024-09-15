package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaJuridica;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

// PErsistencia
@Entity
//@Table(name = "fabricante")
@DiscriminatorValue("FABRICANTE")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public class Fabricante extends PessoaJuridica {
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    protected List<Item> items;
}
