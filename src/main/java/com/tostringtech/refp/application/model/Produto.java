package com.tostringtech.refp.application.model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_PRODUTO")
    private Long codigo;

    @Column(name = "DS_PRODUTO")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "CD_TIP_PROD")
    private TipProd tipoProduto;


    public Produto() {
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

    public TipProd getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipProd tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
