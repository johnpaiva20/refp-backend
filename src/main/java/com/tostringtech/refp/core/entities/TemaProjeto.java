package com.tostringtech.refp.core.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

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
    private TipoProjeto codTipoProjeto;

    public TemaProjeto() {
    }

    public TemaProjeto(String codTema) {
        this.codTema = codTema;
    }

    public TemaProjeto(String codTema, String descTema, TipoProjeto codTipoProjeto) {
        this.codTema = codTema;
        this.descTema = descTema;
        this.codTipoProjeto = codTipoProjeto;
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

    public TipoProjeto getCodTipoProjeto() {
        return codTipoProjeto;
    }

    public void setCodTipoProjeto(TipoProjeto codTipoProjeto) {
        this.codTipoProjeto = codTipoProjeto;
    }

    // private Set<SubtemaProjeto> subtemas;

}
