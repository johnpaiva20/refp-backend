package com.tostringtech.refp.core.entities;

import com.tostringtech.refp.core.entities.relationships.EmpresaProjeto;
import com.tostringtech.refp.core.entities.relationships.MembroProjeto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "PROJETO", uniqueConstraints = {
        @UniqueConstraint(columnNames = "COD_ANEEL", name = "PROJETO_UK_1"),
        @UniqueConstraint(columnNames = "DS_ORDEM_SERVICO", name = "PROJETO_UK_2")})
public class Projeto implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_PROJETO")
    private Long codProjeto;

    @Column(name = "COD_ANEEL", nullable = false)
    private String codAneel;

    @Column(name = "DS_TITULO", nullable = false)
    private String dsTitulo;

    @Column(name = "DT_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtInicio;

    @Column(name = "VL_DURACAO", nullable = false)
    private int vlDuracaoMeses;

    @Column(name = "DS_ORDEM_SERVICO", nullable = false)
    private String dsOrdemServico;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne()
    @JoinColumn(name = "COD_TIPO_PROJETO", foreignKey = @ForeignKey(name = "TIPO_PROJETO_FK"))
    private TipoProjeto tipoProjeto;

    @ManyToOne()
    @JoinColumn(name = "COD_TEMA_PROJETO", foreignKey = @ForeignKey(name = "TEMA_PROJETO_FK"))
    private TemaProjeto tema;

    @ManyToOne()
    @JoinColumn(name = "COD_SUBTEMA_PROJETO", foreignKey = @ForeignKey(name = "SUBTEMA_PROJETO_FK"))
    private SubtemaProjeto subtema;

    @ManyToOne()
    @JoinColumn(name = "COD_SEGMENTO_PROJETO", foreignKey = @ForeignKey(name = "SEGMENTO_PROJETO_FK"))
    private SegmentoProjeto segmento;

    @ManyToOne()
    @JoinColumn(name = "COD_FASE_CADEIA_INOVACAO_PROJETO", foreignKey = @ForeignKey(name = "FASE_CADEIA_INOVACAO_PROJETO_FK"))
    private FaseCadeiaInovacaoProjeto faseCadeiaInovacao;

    @ManyToOne()
    @JoinColumn(name = "COD_TIPO_PRODUTO", foreignKey = @ForeignKey(name = "TIPO_PRODUTO_PROJETO_FK"))
    private TipoProduto produto;


    @OneToMany(targetEntity = Membro.class)
    @JoinTable(name = "MEMBRO_PROJETO",
            joinColumns = {@JoinColumn(name = "COD_PROJETO")},
            inverseJoinColumns = {@JoinColumn(name = "COD_MEMBRO")})
    private Set<MembroProjeto> membros = new HashSet<>();


    @OneToMany(targetEntity = Empresa.class)
    @JoinTable(name = "EMPRESA_PROJETO",
            joinColumns = {@JoinColumn(name = "COD_PROJETO")},
            inverseJoinColumns = {@JoinColumn(name = "COD_EMPRESA")})
    private Set<EmpresaProjeto> empresas = new HashSet<>();

    @OneToMany(targetEntity = Despesa.class)
    @JoinTable(name = "DESPESA")
    private List<Despesa> despesas = new ArrayList<>();
/*
	@JsonIgnore
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RecursoProjeto> recursosProjeto = new ArrayList<RecursoProjeto>();
*/

    public Projeto() {
    }

    public Projeto(Long codProjeto, String codAneel, String dsTitulo, Date dtInicio, int vlDuracaoMeses, String dsOrdemServico, String status, TipoProjeto tipoProjeto, TemaProjeto tema, SubtemaProjeto subtema, SegmentoProjeto segmento, FaseCadeiaInovacaoProjeto faseCadeiaInovacao, TipoProduto produto) {
        this.codProjeto = codProjeto;
        this.codAneel = codAneel;
        this.dsTitulo = dsTitulo;
        this.dtInicio = dtInicio;
        this.vlDuracaoMeses = vlDuracaoMeses;
        this.dsOrdemServico = dsOrdemServico;
        this.status = status;
        this.tipoProjeto = tipoProjeto;
        this.tema = tema;
        this.subtema = subtema;
        this.segmento = segmento;
        this.faseCadeiaInovacao = faseCadeiaInovacao;
        this.produto = produto;
    }

    public Long getCodProjeto() {
        return codProjeto;
    }

    public void setCodProjeto(Long codProjeto) {
        this.codProjeto = codProjeto;
    }

    public String getCodAneel() {
        return codAneel;
    }

    public void setCodAneel(String codAneel) {
        this.codAneel = codAneel;
    }

    public String getDsTitulo() {
        return dsTitulo;
    }

    public void setDsTitulo(String dsTitulo) {
        this.dsTitulo = dsTitulo;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public int getVlDuracaoMeses() {
        return vlDuracaoMeses;
    }

    public void setVlDuracaoMeses(int vlDuracaoMeses) {
        this.vlDuracaoMeses = vlDuracaoMeses;
    }

    public String getDsOrdemServico() {
        return dsOrdemServico;
    }

    public void setDsOrdemServico(String dsOrdemServico) {
        this.dsOrdemServico = dsOrdemServico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TipoProjeto getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipoProjeto tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public TemaProjeto getTema() {
        return tema;
    }

    public void setDescTema(TemaProjeto tema) {
        this.tema = tema;
    }

    public SubtemaProjeto getSubtema() {
        return subtema;
    }

    public void setSubtema(SubtemaProjeto subtema) {
        subtema = subtema;
    }

    public SegmentoProjeto getSegmento() {
        return segmento;
    }

    public void setSegmento(SegmentoProjeto segmento) {
        segmento = segmento;
    }

    public FaseCadeiaInovacaoProjeto getFaseCadeiaInovacao() {
        return faseCadeiaInovacao;
    }

    public void setFaseCadeiaInovacao(FaseCadeiaInovacaoProjeto faseCadeiaInovacao) {
        this.faseCadeiaInovacao = faseCadeiaInovacao;
    }

    public TipoProduto getProduto() {
        return produto;
    }

    public void setProduto(TipoProduto produto) {
        this.produto = produto;
    }

    public Set<MembroProjeto> getMembros() {
        return membros;
    }

    public void setMembros(Set<MembroProjeto> membros) {
        this.membros = membros;
    }

    public Set<EmpresaProjeto> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Set<EmpresaProjeto> empresas) {
        this.empresas = empresas;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
}
