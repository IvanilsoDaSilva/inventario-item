package br.com.ic.inventarioitem.entities.inheritance;

import br.com.ic.inventarioitem.entities.base.PersistenciaBD;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

// Persistencia
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// Lombok
@EqualsAndHashCode(callSuper=true)
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class PessoaJuridica extends PersistenciaBD {
    @NotBlank(message = "A razão social é obrigatório")
    @Size(max = 255, message = "A razão social não pode possuir mais de 255 caracteres")
    @Column(name = "razao_social", length = 255)
    private String razaoSocial;

//    @CNPJ
    @Column(name = "cnpj", length = 20, unique = true)
    private String cnpj;

    @Size(max = 19, message = "O telefone não pode possuir mais de 19 caracteres")
    @Column(name = "telefone", length = 19)
    private String telefone;

    @NotBlank(message = "O E-Mail é obrigatório")
    @Size(max = 255, message = "O E-Mail não pode possuir mais de 255 caracteres")
    @Email
    @Column(name = "email", length = 255, unique = true)
    private String email;

    @Size(max = 255, message = "O site não pode possuir mais de 255 caracteres")
    @Column(name = "site", length = 255, unique = true)
    private String site;
}
