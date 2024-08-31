package br.com.ic.inventarioitem.entities.business;

import br.com.ic.inventarioitem.entities.database.PersistenciaBD;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "item")
@Data
@SuperBuilder
@NoArgsConstructor
public class Item extends PersistenciaBD {
    @Column(name = "codigo", length = 100)
    private String codigo;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "categoria", length = 100)
    private String categoria;

    @Column(name = "anexo", length = 100)
    private String anexo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proprietario_id", referencedColumnName = "id")
    private Proprietario proprietario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_id", referencedColumnName = "id")
    private Fornecedor fornecedor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fabricante_id", referencedColumnName = "id")
    private Fabricante fabricante;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor_id", referencedColumnName = "id")
    private Vendedor vendedor;
}
