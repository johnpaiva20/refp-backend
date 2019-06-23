package com.tostringtech.refp.application.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDEM_SERVICO")
public class OrdemServico {

    @Id
    @Column(name = "CD_ORDEM_SERVICO", length = 20)
    private String codigo;

    @Column(name = "DT_INICIO")
    private Date dataInicio;

    @Column(name = "DT_FIM")
    private Date dataFim;

    public OrdemServico() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
