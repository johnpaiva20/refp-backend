package com.tostringtech.refp.application.models;

import com.tostringtech.refp.project.api.resources.ServiceOrderResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ORDEM_SERVICO")
public class OrdemServico implements Serializable {

    @Id
    @Column(name = "CD_ORDEM_SERVICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "NR_ORDEM_SERVICO", unique = true, updatable = false, nullable = false)
    private String numero;

    @Column(name = "NR_MESES", nullable = false)
    private int duracao;

    @Column(name = "DT_INICIO", nullable = false)
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
        this.setDuracao(serviceOrder.getDuration());
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
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
