package br.com.ic.inventarioitem.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.br.CPF;

@Data
@SuperBuilder
public class UsuarioCriarDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 255, message = "O nome não pode possuir mais de 255 caracteres")
    @Column(name = "nome", length = 255)
    private String nome;

    @CPF
    @Column(name = "cpf", length = 14, unique = true)
    private String cpf;

    @NotBlank(message = "O E-Mail é obrigatório")
    @Size(max = 255, message = "O E-Mail não pode possuir mais de 255 caracteres")
    @Email
    @Column(name = "email", length = 255, unique = true)
    private String email;

    @NotBlank(message = "A senha é obrigatório")
    @Size(max = 255, message = "A senha não pode possuir mais de 255 caracteres")
    @Column(name = "senha", length = 255)
    private String senha;
}
