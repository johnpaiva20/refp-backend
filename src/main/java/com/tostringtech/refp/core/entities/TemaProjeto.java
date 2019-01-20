package com.tostringtech.refp.core.entities;

import com.tostringtech.refp.core.entities.relationships.EmpresaProjeto;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TEMA_PROJETO")
public class TemaProjeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @ApiModelProperty(readOnly = true)
    @Column(name = "COD_TEMA")
    private String codTema;
    @Column(name = "DESC_TEMA")
    private String descTema;

    @ManyToOne()
    @ApiModelProperty()
    @JoinColumn(name = "COD_TIPO_PROJETO", foreignKey = @ForeignKey(name = "TEMA_PROJETO_TIPO_PROJETO_FK"))
    private TipoProjeto tipoProjeto;

    @OneToMany(targetEntity = SubtemaProjeto.class)
    @JoinTable(name = "SUBTEMA_PROJETO",
            joinColumns = {@JoinColumn(name = "COD_TEMA", foreignKey = @ForeignKey(name = "SUBTEMA_TEMA_FK"))},
            inverseJoinColumns = {@JoinColumn(name = "COD_SUBTEMA_PROJETO")})
    private List<SubtemaProjeto> subTema = new ArrayList<>();

    public TemaProjeto() {
    }

    public TemaProjeto(String codTema) {
        this.codTema = codTema;
    }

    public TemaProjeto(String codTema, String descTema, TipoProjeto codTipoProjeto) {
        this.codTema = codTema;
        this.descTema = descTema;
        this.tipoProjeto = codTipoProjeto;
    }

    public String getCodTema() {
        return codTema;
    }

    public void setCodTema(String codTema) {
        this.codTema = codTema;
    }

    public String getDescTema() {
        return descTema;
    }

    public void setDescTema(String descTema) {
        this.descTema = descTema;
    }

    public TipoProjeto getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipoProjeto tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public List<SubtemaProjeto> getSubTema() {
        return subTema;
    }

    public void setSubTema(List<SubtemaProjeto> subTema) {
        this.subTema = subTema;
    }
}
