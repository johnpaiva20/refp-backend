package com.tostringtech.refp.application.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORIA_CONTABIL")
public class CategoriaContabil implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(hidden = true)
    @Column(name = "CD_CATEGORIA_CONTABIL")
    private Long codigo;

    @Column(name = "DS_CATEGORIA_CONTABIL")
    private String descricao;

    @Column(name = "DS_SIGLA")
    private String sigla;

    @Column(name = "SN_PADRAO")
    private String padrao;

    public CategoriaContabil() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getPadrao() {
        return padrao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }
}
