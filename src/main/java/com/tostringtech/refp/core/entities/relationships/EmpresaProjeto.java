package com.tostringtech.refp.core.entities.relationships;

import com.tostringtech.refp.core.entities.Empresa;
import com.tostringtech.refp.core.entities.Projeto;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "EMPRESA_PROJETO")
public class EmpresaProjeto implements Serializable {

    @Id
    @ManyToOne(targetEntity = Empresa.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "COD_EMPRESA", foreignKey = @ForeignKey(name = "EMPRESA_PROJETO_FK"), referencedColumnName = "COD_EMPRESA")
    private Empresa empresa;

    @Id
    @ManyToOne(targetEntity = Projeto.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "COD_PROJETO", foreignKey = @ForeignKey(name = "PROJETO_EMPRESA_FK"), referencedColumnName = "COD_PROJETO")
    private Projeto projeto;

    @Column(name = "TIPO_EMPRESA")
    private String tipoEmpresa;

    @Column(name = "SN_ATIVO")
    private String snAtivo;

    public EmpresaProjeto() {
    }

    public EmpresaProjeto(Empresa empresa, Projeto projeto, String tipoEmpresa) {
        this.setEmpresa(empresa);
        this.setProjeto(projeto);
        this.setTipoEmpresa(tipoEmpresa);
        this.setSnAtivo("S");
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getSnAtivo() {
        return snAtivo;
    }

    public void setSnAtivo(String snAtivo) {
        this.snAtivo = snAtivo;
    }

    public void setSnAtivo(Boolean snAtivo) {
        this.snAtivo = snAtivo ? "S" : "N";
    }
}
