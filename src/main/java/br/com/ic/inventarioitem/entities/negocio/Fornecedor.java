package br.com.ic.inventarioitem.entities.negocio;

import br.com.ic.inventarioitem.entities.reais.PessoaJuridica;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fornecedor")
@Data
public class Fornecedor extends PessoaJuridica {
    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "site", length = 100)
    private String site;
}
