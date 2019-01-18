package com.tostringtech.refp.core.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TIPO_PROJETO")
public class TipoProjeto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty()
    @Column(name = "COD_TIPO_PROJETO")
    private String codTipoProjeto;

    @Column(name = "DESC_TIPO_PROJETO")
    @ApiModelProperty(readOnly = true)
    private String descTipoProjeto;

    @Column(name = "SN_ATIVO", length = 1)
    @ApiModelProperty(readOnly = true)
    private String snAtivo;


    public TipoProjeto() {
    }

    public TipoProjeto(String codTipoProjeto) {
        this.codTipoProjeto = codTipoProjeto;
    }

    public TipoProjeto(String codTipoProjeto, String descTipoProjeto, String snAtivo) {
        super();
        this.codTipoProjeto = codTipoProjeto;
        this.descTipoProjeto = descTipoProjeto;
        this.snAtivo = snAtivo;
    }


    public String getCodTipoProjeto() {
        return codTipoProjeto;
    }


    public void setCodTipoProjeto(String codTipoProjeto) {
        this.codTipoProjeto = codTipoProjeto;
    }


    public String getDescTipoProjeto() {
        return descTipoProjeto;
    }


    public void setDescTipoProjeto(String descTipoProjeto) {
        this.descTipoProjeto = descTipoProjeto;
    }


    public String getSnAtivo() {
        return snAtivo;
    }


    public void setSnAtivo(String snAtivo) {
        this.snAtivo = snAtivo;
    }


}
