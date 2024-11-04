package br.com.ic.inventarioitem.entities.inheritance;

import br.com.ic.inventarioitem.entities.base.PersistenciaBD;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.br.CPF;

// Persistencia
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// Lombok
@EqualsAndHashCode(callSuper=true)
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class PessoaFisica extends PersistenciaBD {
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 255, message = "O nome não pode possuir mais de 255 caracteres")
    @Column(name = "nome", length = 255)
    private String nome;

//    @CPF
    @Column(name = "cpf", length = 14, unique = true)
    private String cpf;

    @NotBlank(message = "O E-Mail é obrigatório")
    @Size(max = 255, message = "O E-Mail não pode possuir mais de 255 caracteres")
    @Email
    @Column(name = "email", length = 255, unique = true)
    private String email;
}
