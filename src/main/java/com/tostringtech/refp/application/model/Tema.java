package com.tostringtech.refp.application.model;

import com.tostringtech.refp.projeto.api.rest.resources.TopicResource;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "TEMA")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "CD_TEMA")
    private long codigo;

    @Column(name = "DS_TEMA")
    private String descricao;

    @OneToOne()
    @JoinColumn(name = "CD_TIP_PROJ")
    private TipProj tipoProjeto;

    @Column(name = "DS_SIGLA")
    private String sigla;

    @Column(name = "SN_PRIORITARIO", length = 1)
    private String prioritario;

    public Tema() {
    }

    public Tema(TopicResource topic) {
        this.setCodigo(topic.getId());
        this.setDescricao(topic.getDescription());
        this.setTipoProjeto(new TipProj(topic.getProjectType()));
        this.setSigla(topic.getInitials());
        this.setPrioritario(topic.isPriority());
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipProj getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipProj tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getPrioritario() {
        return prioritario;
    }

    public void setPrioritario(String prioritario) {
        this.prioritario = prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario ? "S" : "N";
    }
}
