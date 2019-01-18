package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TIPO_PRODUTO")
public class TipoProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_TIPO_PRODUTO")
    private String codTipoProduto;
    @Column(name = "DESC_TIPO_PRODUTO")
    private String descTipoProduto;

    public TipoProduto() {
    }

    public TipoProduto(String codTipoProduto) {
        this.codTipoProduto = codTipoProduto;
    }

    public TipoProduto(String codTipoProduto, String descTipoProduto) {
        this.codTipoProduto = codTipoProduto;
        this.descTipoProduto = descTipoProduto;
    }

    public String getCodTipoProduto() {
        return codTipoProduto;
    }

    public void setCodTipoProduto(String codTipoProduto) {
        this.codTipoProduto = codTipoProduto;
    }

    public String getDescTipoProduto() {
        return descTipoProduto;
    }

    public void setDescTipoProduto(String descTipoProduto) {
        this.descTipoProduto = descTipoProduto;
    }

}
