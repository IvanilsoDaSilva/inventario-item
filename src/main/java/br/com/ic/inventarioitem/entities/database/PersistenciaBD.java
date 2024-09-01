package br.com.ic.inventarioitem.entities.database;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class PersistenciaBD implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @CreationTimestamp(source = SourceType.DB)
    @Column(name = "create_at")
    private Date createAt;

    @UpdateTimestamp(source = SourceType.DB)
    @Column(name = "update_at")
    private Date updateAt;
}
