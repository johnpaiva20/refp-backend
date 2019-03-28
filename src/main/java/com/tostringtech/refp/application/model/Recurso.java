package com.tostringtech.refp.application.model;

import com.tostringtech.refp.categoria_contabil.controller.resources.AssetResource;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "RECURSO")
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "CD_RECURSO")
    private long codigo;

    @Column(name = "DS_RECURSO")
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "CD_CATEGORIA_CONTABIL", foreignKey = @ForeignKey(name = "CNT_RECURSO_RUBRICA_FK"))
    private CategoriaContabil categoriaContabil;

    public Recurso(AssetResource resource) {
        this.codigo=resource.getId();
        this.categoriaContabil.setCodigo(resource.getIdAccountCategory());
        this.descricao=resource.getDescription();
    }


    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaContabil getCategoriaContabil() {
        return categoriaContabil;
    }

    public void setCategoriaContabil(CategoriaContabil categoriaContabil) {
        this.categoriaContabil = categoriaContabil;
    }
}
