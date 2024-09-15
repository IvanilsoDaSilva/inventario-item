package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.inheritance.PessoaFisica;
import br.com.ic.inventarioitem.enums.PapeisUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// Persistencia
@Entity
@Table(name = "usuario")
//@DiscriminatorValue("USUARIO")
// Lombok
@Data
@SuperBuilder
@NoArgsConstructor
public class Usuario extends PessoaFisica implements UserDetails {
    @Size(max = 255, message = "A senha não pode possuir mais de 255 caracteres")
    @Column(name = "senha", length = 255)
    private String senha;

    @Column(name = "papel")
    private PapeisUsuario papel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.papel == PapeisUsuario.ADMINISTRADOR) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else if (this.papel == PapeisUsuario.USUARIO) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
        return null;
    }

    @Override
    public String getPassword() {
        return this.getSenha();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }
}
