package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaJuridica;
import br.com.ic.inventarioitem.enums.TipoLoja;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

// Persistencia
@Entity
@Table(name = "vendedor")
//@DiscriminatorValue("VENDEDOR")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public class Vendedor extends PessoaJuridica {
    @Column(name = "tipo_loja", length = 3)
    private TipoLoja tipoLoja;
}
