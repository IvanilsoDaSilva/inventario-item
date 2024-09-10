package br.com.ic.inventarioitem.entities.business;

import br.com.ic.inventarioitem.entities.abstracts.PessoaJuridica;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "fornecedor")
@Data
@SuperBuilder
@NoArgsConstructor
public class Fornecedor extends PessoaJuridica {
    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email",  length = 100, unique = true)
    private String email;

    @Column(name = "site", length = 100, unique = true)
    private String site;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    protected List<Item> items;
}
