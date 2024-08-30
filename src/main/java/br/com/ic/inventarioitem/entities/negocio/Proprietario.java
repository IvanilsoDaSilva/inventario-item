package br.com.ic.inventarioitem.entities.negocio;

import br.com.ic.inventarioitem.entities.reais.PessoaFisica;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "proprietario")
@Data
public class Proprietario extends PessoaFisica {
    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "cargo", length = 100)
    private String cargo;
}
