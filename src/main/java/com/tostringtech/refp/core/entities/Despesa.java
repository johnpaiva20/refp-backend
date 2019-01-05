package com.tostringtech.refp.core.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codDespesa;
    @Column
    private String nrDocumento;
    @Column
    private double vlDespesa;

    @Column
    private Date dtDespesa;

    @ManyToOne
    @JoinColumn(name = "codProjeto", foreignKey = @ForeignKey(name = "DESPESA_PROJETO_FK"))
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
