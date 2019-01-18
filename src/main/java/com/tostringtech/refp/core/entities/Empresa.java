package com.tostringtech.refp.core.entities;

import javax.persistence.*;

@Entity
@Table(name = "EMPRESA",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "NR_CNPJ", name = "EMPRESA_UK_1")})
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_EMPRESA")
    private Long codEmpresa;
    @Column(name = "NR_CNPJ", nullable = false)
    private String nrCnpj;
    @Column(name = "DESC_RAZAO_SOCIAL", nullable = false)
    private String descRazaoSocial;
    @Column(name = "DESC_NOME_FANTASIA", nullable = false)
    private String descNomeFantasia;
    @Column(name = "DESC_SIGLA", nullable = false)
    private String descSigla;

    public Empresa() {

    }

    public Empresa(Long codEmpresa, String nrCnpj, String descRazaoSocial, String descNomeFantasia, String descSigla) {
        this.codEmpresa = codEmpresa;
        this.nrCnpj = nrCnpj;
        this.descRazaoSocial = descRazaoSocial;
        this.descNomeFantasia = descNomeFantasia;
        this.descSigla = descSigla;
    }

    public Long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNrCnpj() {
        return nrCnpj;
    }

    public void setNrCnpj(String nrCnpj) {
        this.nrCnpj = nrCnpj;
    }

    public String getDescRazaoSocial() {
        return descRazaoSocial;
    }

    public void setDescRazaoSocial(String descRazaoSocial) {
        this.descRazaoSocial = descRazaoSocial;
    }

    public String getDescNomeFantasia() {
        return descNomeFantasia;
    }

    public void setDescNomeFantasia(String descNomeFantasia) {
        this.descNomeFantasia = descNomeFantasia;
    }

    public String getDescSigla() {
        return descSigla;
    }

    public void setDescSigla(String descSigla) {
        this.descSigla = descSigla;
    }
}
