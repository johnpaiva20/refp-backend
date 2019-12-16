package com.tostringtech.refp.application.models;

import com.tostringtech.refp.project.api.resources.TopicResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEMA")
public class Tema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_TEMA")
    private Long codigo;

    @Column(name = "DS_TEMA")
    private String descricao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_TIPO_PROJETO")
    private TipoProjeto tipoProjeto;

    @Column(name = "DS_SIGLA")
    private String sigla;

    @Column(name = "SN_PRIORITARIO", length = 1,columnDefinition = "String default N")
    private String prioritario;

    public Tema() {
    }

    public Tema(TopicResource topic) {
        this.setCodigo(topic.getId());
        this.setDescricao(topic.getDescription());
        this.setSigla(topic.getInitials());
        this.setPrioritario(topic.isPriority());
        if (topic.getProjectType() != null) {
            this.setTipoProjeto(new TipoProjeto(topic.getProjectType()));
        }
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoProjeto getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipoProjeto tipoProjeto) {
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
