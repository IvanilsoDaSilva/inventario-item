package br.com.ic.inventarioitem.entities.inheritance;

import br.com.ic.inventarioitem.entities.base.PersistenciaBD;
import br.com.ic.inventarioitem.entities.core.Item;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

// Persistencia
@Entity
//@Table(name = "pessoa_juridica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "tipo_pessoa_juridica")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class PessoaJuridica extends PersistenciaBD {
    @NotBlank(message = "A razão social é obrigatório")
    @Size(max = 255, message = "A razão social não pode possuir mais de 255 caracteres")
    @Column(name = "razao_social", length = 255)
    private String razaoSocial;

    @CNPJ
    @Column(name = "cnpj", length = 18, unique = true)
    private String cnpj;

    @Pattern(
            regexp = "^(\\(?\\d{2}\\)?\\s?)?(\\d{5}-\\d{4}|\\d{4}-\\d{4}|\\d{8,9})$",
            message = "O número de telefone celular está inválido"
    )
    @Column(name = "telefone", length = 19)
    private String telefone;

    @NotBlank(message = "O E-Mail é obrigatório")
    @Size(max = 255, message = "O E-Mail não pode possuir mais de 255 caracteres")
    @Email
    @Column(name = "email", length = 255, unique = true)
    private String email;

    @Pattern(
            regexp = "^(https?:\\/\\/)?([a-zA-Z0-9.-]+)(:\\d+)?(\\/[^\\s]*)?$\n",
            message = "O site está inválido"
    )
    @Size(max = 255, message = "O site não pode possuir mais de 255 caracteres")
    @Column(name = "site", length = 255, unique = true)
    private String site;
}
