package com.tostringtech.refp.application.models;

import com.tostringtech.refp.projeto.api.rest.resources.ProjectResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "PROJETO")
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_PROJETO")
    private Long codigo;

    @Column(name = "CD_ANEEL", nullable = false, unique = true, updatable = false, length = 20)
    private String codigoAneel;

    @Column(name = "DS_TITULO", nullable = false, length = 200)
    private String titulo;

    @Column(name = "VL_DURACAO", nullable = false)
    private int duracao;

    @Column(name = "DS_SEGMENTO", length = 1)
    private String segmento;

    @Column(name = "DS_STATUS", nullable = false)
    private String status;

    @Column(name = "DS_FASE_INOVACAO")
    private String faseInovacao;

    @Column(name = "DS_TIPO_COMPARTILHAMENTO")
    private String tipoCompartilhamento;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CD_ORDEM_SERVICO")
    private OrdemServico ordemServico;

    @OneToOne
    @JoinColumn(name = "CD_TIPO_PROJETO")
    private TipoProjeto tipoProjeto;

    @OneToOne
    @JoinColumn(name = "CD_TEMA")
    private Tema tema;

    @OneToOne
    @JoinColumn(name = "CD_SUBTEMA")
    private Subtema subtema;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CD_PRODUTO")
    private Produto produto;

    @OneToMany(mappedBy = "projeto")
    private List<MembPro> membros = new ArrayList<>();

    @OneToMany(mappedBy = "projeto")
    private List<Despesa> despesas = new ArrayList<>();

    @OneToMany(mappedBy = "projeto")
    private List<EmpPro> empresas = new ArrayList<>();

    public Projeto() {
    }

    public Projeto(ProjectResource resource) {

        this.setCodigo(resource.getId());
        this.setCodigoAneel(resource.getAneelId());
        this.setTitulo(resource.getTitle());
        this.setDuracao(resource.getDuration());
        this.setStatus(resource.getStatus());
        this.setSegmento(resource.getSegment());
        this.setFaseInovacao(resource.getInnovationPhase());
        this.setTipoCompartilhamento(resource.getSharingMethod());

        if (resource.getServiceOrder() != null) {
            OrdemServico ordemServico = new OrdemServico(resource.getServiceOrder());
            ordemServico.setDataFim(this.calculateCompletionDate(ordemServico, getDuracao()));
            this.setOrdemServico(ordemServico);
        }
        if (resource.getType() != null) {
            this.setTipoProjeto(new TipoProjeto(resource.getType()));
        }
        if (resource.getTopic() != null) {
            this.setTema(new Tema(resource.getTopic()));
        }
        if (resource.getSubtopic() != null) {
            this.setSubtema(new Subtema(resource.getSubtopic()));
        }
        if (resource.getProduct() != null) {
            this.setProduto(new Produto(resource.getProduct()));
        }
        if (resource.getEnterprises() != null) {
            List<EmpPro> empresas = resource.getEnterprises().stream().map(EmpPro::new).collect(Collectors.toList());
            this.setEmpresas(empresas);
        }
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFaseInovacao() {
        return faseInovacao;
    }

    public void setFaseInovacao(String faseInovacao) {
        this.faseInovacao = faseInovacao;
    }

    public String getTipoCompartilhamento() {
        return tipoCompartilhamento;
    }

    public void setTipoCompartilhamento(String tipoCompartilhamento) {
        this.tipoCompartilhamento = tipoCompartilhamento;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public TipoProjeto getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipoProjeto tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Subtema getSubtema() {
        return subtema;
    }

    public void setSubtema(Subtema subtema) {
        this.subtema = subtema;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<MembPro> getMembros() {
        return membros;
    }

    public void setMembros(List<MembPro> membros) {
        this.membros = membros;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public List<EmpPro> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<EmpPro> empresas) {
        this.empresas = empresas;
    }

    public Date calculateCompletionDate(OrdemServico ordemServico, int duracao) {
        Calendar end = Calendar.getInstance();
        end.setTime(ordemServico.getDataInicio());
        end.add(Calendar.MONTH, duracao);
        return end.getTime();
    }
}
