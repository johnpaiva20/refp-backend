package com.tostringtech.refp.application.models;

import com.tostringtech.refp.project.api.resources.SubtopicResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SUBTEMA")
public class Subtema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_SUBTEMA")
    private Long codigo;

    @Column(name = "DS_SUBTEMA")
    private String descricao;

    @Column(name = "DS_SIGLA")
    private String sigla;

    @Column(name = "SN_PRIORITARIO", length = 1)
    private String prioritario;

    @OneToOne()
    @JoinColumn(name = "DS_SIGLA_TEMA", referencedColumnName = "DS_SIGLA")
    private Tema tema;

    public Subtema() {
    }

    public Subtema(Long codigo, String descricao, String sigla, String prioritario, Tema tema) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.sigla = sigla;
        this.prioritario = prioritario;
        this.tema = tema;
    }

    public Subtema(SubtopicResource subtopic) {
        this.setCodigo(subtopic.getId());
        this.setDescricao(subtopic.getDescription());
        this.setSigla(subtopic.getInitials());
        this.setPrioritario(subtopic.isPriority());
        if (subtopic.getTopic() != null) {
            this.setTema(new Tema(subtopic.getTopic()));
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


    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
