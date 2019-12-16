package com.tostringtech.refp.application.models;

import com.tostringtech.refp.expense.api.resources.ExpenseResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DESPESA")
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_DESPESA")
    private Long codigo;

    @Column(name = "NR_DOCUMENTO")
    private String numeroDocumento;

    @Column(name = "VL_DESPESA")
    private double valor;

    @Column(name = "DT_DESPESA")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "COD_PROJETO", foreignKey = @ForeignKey(name = "DESPESA_PROJETO_FK"))
    private Projeto projeto;

    public Despesa() {

    }

    public Despesa(ExpenseResource resource) {
    }
}




