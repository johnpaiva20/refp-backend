package com.tostringtech.refp.application.model;

import com.tostringtech.refp.application.domain.TipoProjeto;
import com.tostringtech.refp.projeto.controller.resources.ProjectResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PROJETO")
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

    @Column(name = "TP_PROJETO",  length = 2)
    private String tipoProjeto;

    @Column(name = "CD_SEGMENTO",  length = 1)
    private String segmento;

    @Column(name = "CD_TEMA",  length = 2)
    private String tema;

    @Column(name = "CD_SUBTEMA",  length = 4)
    private String subtema;

    @Column(name = "TP_PRODUTO",  length = 2)
    private String produto;

    @Column(name = "TP_FASE_INOVACAO",  length = 2)
    private String faseInovacao;

    public Projeto() {
    }

    public Projeto(ProjectResource resource) {
        this.codigo = resource.getId();
        this.codigoAneel = resource.getAneelId();
        this.titulo = resource.getTitle();
        this.dataInicio = resource.getStart();
        this.valorDuracaoMeses = resource.getDuration();
        this.ordemServico = resource.getServiceOrder();
        this.status = resource.getStatus() != null ? resource.getStatus() : "ANDAMENTO";
        this.tipoProjeto = TipoProjeto.toEnum(resource.getType()).getCodigo();
        this.produto = resource.getProduct();
        this.faseInovacao = resource.getInnovationPhase();
        this.tema = resource.getTopic();
        this.subtema = resource.getSubtopic();
        this.segmento = resource.getSegment();
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

    public String getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(String tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getSubtema() {
        return subtema;
    }

    public void setSubtema(String subtema) {
        this.subtema = subtema;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getFaseInovacao() {
        return faseInovacao;
    }

    public void setFaseInovacao(String faseInovacao) {
        this.faseInovacao = faseInovacao;
    }
}
