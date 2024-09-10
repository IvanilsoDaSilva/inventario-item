package br.com.ic.inventarioitem.entities.business;

import br.com.ic.inventarioitem.entities.abstracts.PessoaJuridica;
import br.com.ic.inventarioitem.enums.TipoLoja;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "vendedor")
@Data
@SuperBuilder
@NoArgsConstructor
public class Vendedor extends PessoaJuridica {
    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "site", length = 100, unique = true)
    private String site;

    @Column(name = "tipo_loja", length = 3)
    private TipoLoja tipoLoja;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    protected List<Item> items;
}
