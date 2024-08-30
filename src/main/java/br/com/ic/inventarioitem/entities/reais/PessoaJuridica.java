package br.com.ic.inventarioitem.entities.reais;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class PessoaJuridica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "razao_social", length = 100)
    private String razaoSocial;

    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;
}
