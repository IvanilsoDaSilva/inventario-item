package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaJuridica;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

// PErsistencia
@Entity
//@Table(name = "fabricante")
@DiscriminatorValue("FABRICANTE")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public class Fabricante extends PessoaJuridica {
}
