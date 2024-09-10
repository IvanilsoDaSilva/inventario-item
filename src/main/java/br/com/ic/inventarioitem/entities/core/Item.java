package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.base.PersistenciaBD;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

// Persistencia
@Entity
@Table(name = "item")
// PErsistencia
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(
            name = "id_proprietario",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_item_proprietario")
    )
    private Proprietario proprietario;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(
            name = "id_fornecedor",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_item_fornecedor")
    )
    private Fornecedor fornecedor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(
            name = "id_fabricante",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_item_fabricante")
    )
    private Fabricante fabricante;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(
            name = "id_vendedor",
            referencedColumnName = "id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_item_vendedor")
    )
    private Vendedor vendedor;
}
