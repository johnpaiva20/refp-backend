package com.tostringtech.refp.application.model;

import com.tostringtech.refp.application.domain.TipoProjeto;
import com.tostringtech.refp.projeto.controller.resources.ProjectResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROJETO", uniqueConstraints = {
        @UniqueConstraint(columnNames = "CD_ANEEL", name = "PROJETO_UK_1"),
        @UniqueConstraint(columnNames = "DS_ORDEM_SERVICO", name = "PROJETO_UK_2")})
public class Projeto implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_PROJETO")
    private Long codigo;

    @Column(name = "CD_ANEEL", nullable = false)
    private String codigoAneel;

    @Column(name = "DS_TITULO", nullable = false)
    private String titulo;

    @Column(name = "DT_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column(name = "VL_DURACAO", nullable = false)
    private int valorDuracaoMeses;

    @Column(name = "DS_ORDEM_SERVICO", nullable = false)
    private String ordemServico;

    @Column(name = "DS_STATUS", nullable = false)
    private String status;

    @Column(name = "TP_PROJETO", nullable = false, length = 2)
    private String tipoProjeto;


    @OneToMany(targetEntity = Despesa.class)
    @JoinTable(name = "DESPESA")
    private List<Despesa> despesas = new ArrayList<>();

    public Projeto() {
    }

    public Projeto(ProjectResource resource) {
        this.codigo = resource.getId();
        this.codigoAneel = resource.getAneelId();
        this.titulo = resource.getTitle();
        this.dataInicio = resource.getStartDate();
        this.valorDuracaoMeses = resource.getDuration();
        this.ordemServico = resource.getServiceOrder();
        this.status = resource.getStatus();
        this.tipoProjeto =TipoProjeto.toEnum(resource.getType()).getCodigo();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCodigoAneel() {
        return codigoAneel;
    }

    public void setCodigoAneel(String codigoAneel) {
        this.codigoAneel = codigoAneel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getValorDuracaoMeses() {
        return valorDuracaoMeses;
    }

    public void setValorDuracaoMeses(int valorDuracaoMeses) {
        this.valorDuracaoMeses = valorDuracaoMeses;
    }

    public String getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(String ordemServico) {
        this.ordemServico = ordemServico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public String getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(String tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }
}
