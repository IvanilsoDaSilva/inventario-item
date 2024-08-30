package br.com.ic.inventarioitem.entities.negocio;

import br.com.ic.inventarioitem.entities.reais.PessoaFisica;
import br.com.ic.inventarioitem.enums.TipoUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario extends PessoaFisica {
    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "senha", length = 100)
    private String senha;

    @Column(name = "tipo_usuario", length = 3)
    private TipoUsuario tipoUsuario;
}
