package br.com.ic.inventarioitem.entities.business;

import br.com.ic.inventarioitem.entities.abstracts.PessoaFisica;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "proprietario")
@Data
@SuperBuilder
@NoArgsConstructor
public class Proprietario extends PessoaFisica {
    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "cargo", length = 100)
    private String cargo;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    protected List<Item> items;
}