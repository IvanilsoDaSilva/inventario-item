package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaJuridica;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

// Persistencia
@Entity
@Table(name = "fornecedor")
//@DiscriminatorValue("FORNECEDOR")
// Lombok
@EqualsAndHashCode(callSuper=true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Fornecedor extends PessoaJuridica {
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    protected List<Item> items;
}
