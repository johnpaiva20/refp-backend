package com.tostringtech.refp.application.model;

import com.tostringtech.refp.empresa.controller.resources.EnterpriseResource;

import javax.persistence.*;

@Entity
@Table(name = "EMPRESA")
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

    public Empresa(Long codigo, String numeroCnpj, String razaoSocial, String nomeFantasia, String sigla) {
        this.codigo = codigo;
        this.numeroCnpj = numeroCnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.sigla = sigla;
    }

    public Empresa(EnterpriseResource resource) {
        this.codigo = resource.getId();
        this.numeroCnpj = resource.getCnpj();
        this.razaoSocial = resource.getCompany();
        this.nomeFantasia = resource.getTrade();
        this.sigla = resource.getInitials();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNumeroCnpj() {
        return numeroCnpj;
    }

    public void setNumeroCnpj(String numeroCnpj) {
        this.numeroCnpj = numeroCnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
