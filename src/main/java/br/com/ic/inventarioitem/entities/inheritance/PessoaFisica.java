package br.com.ic.inventarioitem.entities.inheritance;

import br.com.ic.inventarioitem.entities.base.PersistenciaBD;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

// Persistencia
@Entity
//@Table(name = "pessoa_fisica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "tipo_pessoa_fisica")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class PessoaFisica extends PersistenciaBD {
    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;

    @Column(name = "email", length = 100, unique = true)
    private String email;
}
