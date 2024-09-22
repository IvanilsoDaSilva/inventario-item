package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaJuridica;
import br.com.ic.inventarioitem.enums.TipoLoja;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

// Persistencia
@Entity
@Table(name = "vendedor")
//@DiscriminatorValue("VENDEDOR")
// Lombok
@EqualsAndHashCode(callSuper=true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Vendedor extends PessoaJuridica {
    @Column(name = "tipo_loja", length = 3)
    private TipoLoja tipoLoja;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    protected List<Item> items;
}
