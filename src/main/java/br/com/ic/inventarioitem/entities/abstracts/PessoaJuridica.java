package br.com.ic.inventarioitem.entities.abstracts;

import br.com.ic.inventarioitem.entities.database.PersistenciaBD;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class PessoaJuridica extends PersistenciaBD {
    @Column(name = "razao_social", length = 100)
    private String razaoSocial;

    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;
}
