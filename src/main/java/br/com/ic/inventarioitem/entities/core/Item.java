package br.com.ic.inventarioitem.entities.core;

import br.com.ic.inventarioitem.entities.base.PersistenciaBD;
import br.com.ic.inventarioitem.enums.CategoriaItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

// Persistencia
@Entity
@Table(name = "item")
// Persistencia
@EqualsAndHashCode(callSuper=true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Item extends PersistenciaBD {
    @NotBlank(message = "O código do item é obrigatório")
    @Size(max = 255, message = "O código do item não pode possuir mais de 255 caracteres")
    @Column(name = "codigo", length = 255)
    private String codigo;

    @NotBlank(message = "O nome do item é obrigatório")
    @Size(max = 255, message = "O nome do item não pode possuir mais de 255 caracteres")
    @Column(name = "nome", length = 255)
    private String nome;

    @Size(max = 255, message = "A descrição do item não pode possuir mais de 255 caracteres")
    @Column(name = "descricao")
    private String descricao;

    @Size(max = 255, message = "A categoria do item não pode possuir mais de 255 caracteres")
    @Column(name = "categoria", length = 255)
    private CategoriaItem categoria;

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
