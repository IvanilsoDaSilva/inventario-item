package br.com.ic.inventarioitem.entities.business;

import br.com.ic.inventarioitem.entities.abstracts.PessoaFisica;
import br.com.ic.inventarioitem.enums.PapeisUsuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@SuperBuilder
@NoArgsConstructor
public class Usuario extends PessoaFisica implements UserDetails {
    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "senha", length = 100)
    private String senha;

    @Column(name = "papel")
    private PapeisUsuario papel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.papel == PapeisUsuario.USUARIO_ADMINISTRADOR)
            return List.of(
                    new SimpleGrantedAuthority("administrador"),
                    new SimpleGrantedAuthority("operador")
            );
        else
            return List.of(
                    new SimpleGrantedAuthority("USUARIO_COMUM")
            );
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
