package br.com.ic.inventarioitem.entities.abstracts;

import br.com.ic.inventarioitem.entities.database.PersistenciaBD;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class PessoaFisica extends PersistenciaBD {
    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;
}
