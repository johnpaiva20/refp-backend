package com.tostringtech.refp.application.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MEMB_PRO")
public class MembPro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MEMB_PRO")
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "CD_PROJETO")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "CD_MEMBRO")
    private Membro membro;

    @Column(name = "TP_FUNCAO", nullable = false, length = 1)
    private String funcao;

    @Column(name = "TP_TITULACAO", nullable = false, length = 1)
    private String titulacao;

}
