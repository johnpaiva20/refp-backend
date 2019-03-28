package com.tostringtech.refp.application.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "SUBTEMA")
public class Subtema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "CD_SUBTEMA")
    private long codigo;

    @Column(name = "DS_SUBTEMA")
    private String descricao;

    @Column(name = "DS_SIGLA")
    private String sigla;

    @Column(name = "SN_PRIORITARIO")
    private String prioritario;

    @Column(name = "DS_SIGLA_TEMA")
    private String tema;

    public Subtema() {
    }

    public Subtema(long codigo, String descricao, String sigla, String prioritario, String tema) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.sigla = sigla;
        this.prioritario = prioritario;
        this.tema = tema;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getPrioritario() {
        return prioritario;
    }

    public void setPrioritario(String prioritario) {
        this.prioritario = prioritario;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
