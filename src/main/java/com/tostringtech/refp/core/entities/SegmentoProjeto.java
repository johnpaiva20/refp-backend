package com.tostringtech.refp.core.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SEGMENTO_PROJETO")
public class SegmentoProjeto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(readOnly = true)
    @Column(name = "COD_SEGMENTO")
    private String codSegmento;
    @Column(name = "DESC_SEGMENTO")
    private String descSegmento;

    public SegmentoProjeto() {
    }

    public SegmentoProjeto(String codSegmento) {
        this.codSegmento = codSegmento;
    }

    public SegmentoProjeto(String codSegmento, String descSegmento) {
        this.codSegmento = codSegmento;
        this.descSegmento = descSegmento;
    }

    public String getCodSegmento() {
        return codSegmento;
    }

    public void setCodSegmento(String codSegmento) {
        this.codSegmento = codSegmento;
    }

    public String getDescSegmento() {
        return descSegmento;
    }

    public void setDescSegmento(String descSegmento) {
        this.descSegmento = descSegmento;
    }

}
