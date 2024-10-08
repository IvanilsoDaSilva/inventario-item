package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaFisica;
import br.com.ic.inventarioitem.enums.PapelUsuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

// Persistencia
@Entity
@Table(name = "usuario")
// Lombok
@EqualsAndHashCode(callSuper=true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Usuario extends PessoaFisica {
    @NotBlank(message = "A senha é obrigatório")
    @Size(max = 255, message = "A senha não pode possuir mais de 255 caracteres")
    @Column(name = "password", length = 255)
    private String senha;

    @Column(name = "papel")
    private PapelUsuario papel;
}
