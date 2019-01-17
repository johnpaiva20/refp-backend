package com.tostringtech.refp.core.entities;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DESPESA")
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_DESPESA")
    private Long codDespesa;
    @Column(name = "NR_DOCUMENTO")
    private String nrDocumento;
    @Column(name = "VL_DESPESA")
    private double vlDespesa;

    @Column(name = "DT_DESPESA")
    private Date dtDespesa;

    @ManyToOne
    @JoinColumn(name = "COD_PROJETO", foreignKey = @ForeignKey(name = "DESPESA_PROJETO_FK"))
    private Projeto projeto;

    public Despesa() {

    }

    public Despesa(Long codDespesa, String nrDocumento, double vlDespesa, Date dtDespesa) {
        this.codDespesa = codDespesa;
        this.nrDocumento = nrDocumento;
        this.vlDespesa = vlDespesa;
        this.dtDespesa = dtDespesa;
    }

    public Long getCodDespesa() {
        return codDespesa;
    }

    public void setCodDespesa(Long codDespesa) {
        this.codDespesa = codDespesa;
    }

    public String getNrDocumento() {
        return nrDocumento;
    }

    public void setNrDocumento(String nrDocumento) {
        this.nrDocumento = nrDocumento;
    }

    public double getVlDespesa() {
        return vlDespesa;
    }

    public void setVlDespesa(double vlDespesa) {
        this.vlDespesa = vlDespesa;
    }

    public Date getDtDespesa() {
        return dtDespesa;
    }

    public void setDtDespesa(Date dtDespesa) {
        this.dtDespesa = dtDespesa;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
