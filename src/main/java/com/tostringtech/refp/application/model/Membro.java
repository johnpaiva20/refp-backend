package com.tostringtech.refp.application.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MEMBRO", uniqueConstraints = {
        @UniqueConstraint(columnNames = "NR_CPF", name = "MEMBRO_UK_1")})
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MEMBRO")
    private Long codigo;

    @Column(name = "NM_MEMBRO", nullable = false)
    private String nome;

    @Column(name = "NR_CPF", nullable = false)
    private String numeroCpf;

    @Column(name = "DS_EMAIL", nullable = true)
    private String email;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private Date dtNascimento;

    @Column(name = "TP_TITULACAO", nullable = false)
    private String  titulacao;

    @Column(name = "TP_FUNCAO", nullable = false)
    private String  funcao;

    @Column(name = "SN_BRASILEIRO", nullable = false)
    private String  brasileiro;

    @Column(name = "NR_PASSAPORTE", nullable = true)
    private String  numeroPassaporte;


    public Membro() {
    }


}
