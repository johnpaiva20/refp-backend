package com.tostringtech.refp.application.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPRESA",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "NR_CNPJ", name = "EMPRESA_UK_1")})
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_EMPRESA")
    private Long codigo;
    @Column(name = "NR_CNPJ", nullable = false)
    private String numeroCnpj;
    @Column(name = "DS_RAZAO_SOCIAL", nullable = false)
    private String razaoSocial;
    @Column(name = "DS_NOME_FANTASIA", nullable = false)
    private String nomeFantasia;
    @Column(name = "DS_SIGLA", nullable = false)
    private String sigla;

    public Empresa() {

    }

}
