package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaFisica;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

// PErsistencia
@Entity
@Table(name = "proprietario")
//@DiscriminatorValue("PROPRIETARIO")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public class Proprietario extends PessoaFisica {
    @Pattern(
            regexp = "^(\\(?\\d{2}\\)?\\s?)?(\\d{5}-\\d{4}|\\d{4}-\\d{4}|\\d{8,9})$",
            message = "O número de telefone celular está inválido"
    )
    @Column(name = "telefone", length = 19)
    private String telefone;

    @Size(max = 255, message = "O cargo não pode possuir mais de 255 caracteres")
    @Column(name = "cargo", length = 255)
    private String cargo;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    protected List<Item> items;
}
