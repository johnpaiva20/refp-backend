package com.tostringtech.refp.application.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "TEMA")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "CD_TEMA")
    private long codigo;

    @Column(name = "DS_TEMA")
    private String descricao;

    @OneToOne()
    @JoinColumn(name = "CD_TIP_PRO")
    private TipPro tipoProjeto;

    @Column(name = "DS_SIGLA")
    private String sigla;

    @Column(name = "SN_PRIORITARIO", length = 1)
    private String prioritario;

    public Tema() {
    }

    public Tema(long codigo, String descricao, TipPro tipoProjeto, String sigla, String prioritario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipoProjeto = tipoProjeto;
        this.sigla = sigla;
        this.prioritario = prioritario;
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

    public TipPro getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipPro tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
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
}
