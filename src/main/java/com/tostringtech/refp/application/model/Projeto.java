package com.tostringtech.refp.application.model;

import com.tostringtech.refp.projeto.api.rest.resources.ProjectResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(name = "VL_DURACAO", nullable = false)
    private int valorDuracaoMeses;

    @Column(name = "DS_STATUS", nullable = false)
    private String status;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CD_ORDEM_SERVICO")
    private OrdemServico ordemServico;

    @OneToOne
    @JoinColumn(name = "CD_TIP_PROJ")
    private TipProj tipoProjeto;

    @OneToOne
    @JoinColumn(name = "CD_TEMA")
    private Tema tema;

    @OneToOne
    @JoinColumn(name = "CD_SUBTEMA")
    private Subtema subtema;

    @OneToOne
    @JoinColumn(name = "CD_SEGMENTO")
    private Segmento segmento;

    @OneToOne
    @JoinColumn(name = "CD_PRODUTO")
    private Produto produto;

    @OneToOne
    @JoinColumn(name = "CD_FASE_INOVA")
    private FaseInova faseInovacao;

    /*private TipCompartiResultados tipoCompartilhamento;*/

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
        this.setValorDuracaoMeses(resource.getDuration());
        this.setStatus(resource.getStatus());
        if (resource.getServiceOrder() != null) {
            this.setOrdemServico(new OrdemServico(resource.getServiceOrder()));
        }
        if (resource.getType() != null) {
            this.setTipoProjeto(new TipProj(resource.getType()));
        }
        if (resource.getTopic() != null) {
            this.setTema(new Tema(resource.getTopic()));
        }
        if (resource.getSubtopic() != null) {
            this.setSubtema(new Subtema(resource.getSubtopic()));
        }
        if (resource.getSegment() != null) {
            this.setSegmento(new Segmento(resource.getSegment()));
        }
        if (resource.getProduct() != null) {
            this.setProduto(new Produto(resource.getProduct()));
        }
        if (resource.getInnovationPhase() != null) {
            this.setFaseInovacao(new FaseInova(resource.getInnovationPhase()));
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

    public int getValorDuracaoMeses() {
        return valorDuracaoMeses;
    }

    public void setValorDuracaoMeses(int valorDuracaoMeses) {
        this.valorDuracaoMeses = valorDuracaoMeses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public TipProj getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipProj tipoProjeto) {
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

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public FaseInova getFaseInovacao() {
        return faseInovacao;
    }

    public void setFaseInovacao(FaseInova faseInovacao) {
        this.faseInovacao = faseInovacao;
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
}
