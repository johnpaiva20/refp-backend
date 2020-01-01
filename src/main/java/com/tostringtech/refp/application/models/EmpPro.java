package com.tostringtech.refp.application.models;

import com.tostringtech.refp.project.api.resources.ProjectEnterpriseResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMP_PRO", uniqueConstraints = {@UniqueConstraint(columnNames = {"CD_EMP_PRO", "CD_PROJETO", "CD_EMPRESA"})})
public class EmpPro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_EMP_PRO")
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "CD_PROJETO", referencedColumnName = "CD_PROJETO")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "CD_EMPRESA")
    private Empresa empresa;

    @Column(name = "TP_EMP_PRO", nullable = false, length = 1)
    private String tipoEmpresa;

    @Column(name = "SN_ATIVO", nullable = false, length = 1)
    private String ativo;


    public EmpPro() {
    }

    public EmpPro(ProjectEnterpriseResource resource) {
        this.setCodigo(resource.getId());
        this.setAtivo(resource.getActive() ? "S" : "N");
        this.setTipoEmpresa(resource.getType());
        if (resource.getEnterprise() != null) {
            this.setEmpresa(new Empresa(resource.getEnterprise()));
        }
        if (resource.getProject() != null) {
            this.setProjeto(new Projeto(resource.getProject()));
        }
    }


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
