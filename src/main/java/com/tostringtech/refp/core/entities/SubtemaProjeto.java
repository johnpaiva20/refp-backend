package com.tostringtech.refp.core.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SUBTEMA_PROJETO")
public class SubtemaProjeto implements Serializable {


    @Id
    @ApiModelProperty(readOnly = true)
    @Column(name = "COD_SUBTEMA_PROJETO")
    private String codSubtemaProjeto;
    @Column(name = "DESC_SUBTEMA_PROJETO")
    private String descSubtemaProjeto;

    @ManyToOne()
    @JoinColumn(name = "COD_TEMA")
    private TemaProjeto temaProjeto;

    public SubtemaProjeto() {
    }

    public SubtemaProjeto(String codSubtemaProjeto) {
        this.codSubtemaProjeto = codSubtemaProjeto;
    }

    public SubtemaProjeto(String codSubtemaProjeto, String descSubtemaProjeto, TemaProjeto temaProjeto) {
        this.codSubtemaProjeto = codSubtemaProjeto;
        this.descSubtemaProjeto = descSubtemaProjeto;
        this.temaProjeto = temaProjeto;
    }

    public String getCodSubtemaProjeto() {
        return codSubtemaProjeto;
    }

    public void setCodSubtemaProjeto(String codSubtemaProjeto) {
        this.codSubtemaProjeto = codSubtemaProjeto;
    }

    public String getDescSubtemaProjeto() {
        return descSubtemaProjeto;
    }

    public void setDescSubtemaProjeto(String descSubtemaProjeto) {
        this.descSubtemaProjeto = descSubtemaProjeto;
    }

    public TemaProjeto getTemaProjeto() {
        return temaProjeto;
    }

    public void setTemaProjeto(TemaProjeto temaProjeto) {
        this.temaProjeto = temaProjeto;
    }
}
