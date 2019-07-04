package com.tostringtech.refp.application.model;

import com.tostringtech.refp.projeto.api.rest.resources.ServiceOrderResource;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDEM_SERVICO")
public class OrdemServico {

    @Id
    @Column(name = "CD_ORDEM_SERVICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "NR_ORDEM_SERVICO", length = 20, unique = true, updatable = false)
    private String numero;

    @Column(name = "DT_INICIO")
    private Date dataInicio;

    @Column(name = "DT_FIM")
    private Date dataFim;

    public OrdemServico() {
    }

    public OrdemServico(ServiceOrderResource serviceOrder) {
        this.setCodigo(serviceOrder.getId());
        this.setNumero(serviceOrder.getNumber());
        this.setDataInicio(serviceOrder.getBegin());
        this.setDataFim(serviceOrder.getEnd());
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
