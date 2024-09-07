package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaJuridica;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

// Persistencia
@Entity
@Table(name = "fornecedor")
//@DiscriminatorValue("FORNECEDOR")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public class Fornecedor extends PessoaJuridica {
}
