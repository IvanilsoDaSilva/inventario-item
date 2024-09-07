package br.com.ic.inventarioitem.entities.inheritance;

import br.com.ic.inventarioitem.entities.base.PersistenciaBD;
import br.com.ic.inventarioitem.entities.core.Item;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

// Persistencia
@Entity
//@Table(name = "pessoa_juridica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "tipo_pessoa_juridica")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class PessoaJuridica extends PersistenciaBD {
    @Column(name = "razao_social", length = 100)
    private String razaoSocial;

    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "site", length = 100, unique = true)
    private String site;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    protected List<Item> items;
}
