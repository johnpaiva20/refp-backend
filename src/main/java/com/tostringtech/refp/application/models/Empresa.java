package com.tostringtech.refp.application.models;

import com.tostringtech.refp.enterprise.api.resources.EnterpriseResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

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
        this.setCodigo(resource.getId());
        this.setNumeroCnpj(resource.getCnpj());
        this.setRazaoSocial(resource.getCompany());
        this.setNomeFantasia(resource.getTrade());
        this.setSigla(resource.getInitials());
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
