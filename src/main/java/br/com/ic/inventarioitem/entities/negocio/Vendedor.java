package br.com.ic.inventarioitem.entities.negocio;

import br.com.ic.inventarioitem.entities.reais.PessoaJuridica;
import br.com.ic.inventarioitem.enums.TipoLoja;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vendedor")
@Data
public class Vendedor extends PessoaJuridica {
    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "site", length = 100)
    private String site;

    @Column(name = "tipo_loja", length = 3)
    private TipoLoja tipoLoja;
}
