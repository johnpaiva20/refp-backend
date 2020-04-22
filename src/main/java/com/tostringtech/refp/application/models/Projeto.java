package com.tostringtech.refp.application.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tostringtech.refp.project.api.enums.ProjectType;
import com.tostringtech.refp.project.api.resources.ProjectResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "PROJETO")
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_PROJETO")
    private Long codigo;

    @Column(name = "CD_ANEEL", nullable = false, unique = true, updatable = false)
    private String codigoAneel;

    @Column(name = "DS_TITULO", nullable = false, length = 200)
    private String titulo;

    @Column(name = "TP_PROJETO", nullable = false, length = 2)
    private String tipo;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CD_ORDEM_SERVICO", nullable = false)
    private OrdemServico ordemServico;

    @OneToMany(mappedBy = "projeto")
    private List<MembPro> membros = new ArrayList<>();

    @JsonIgnoreProperties("projeto")
    @OneToMany(mappedBy = "projeto")
    private List<Despesa> despesas = new ArrayList<>();

    @JsonIgnoreProperties("projeto")
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "CD_PROJETO", referencedColumnName = "CD_PROJETO")
    private List<EmpPro> empresas = new ArrayList<>();

    public Projeto() {
    }

    public Projeto(ProjectResource resource) {

        this.setCodigo(resource.getId());
        this.setCodigoAneel(resource.getAneelId());
        this.setTitulo(resource.getTitle());
        this.setTipo(resource.getType().getType());
        if (resource.getServiceOrder() != null) {
            this.setOrdemServico(new OrdemServico(resource.getServiceOrder()));
        }
    }

    public Projeto(Long id) {
        this.setCodigo(id);
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCodigoAneel() {
        return codigoAneel;
    }

    public void setCodigoAneel(String codigoAneel) {
        this.codigoAneel = codigoAneel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public List<MembPro> getMembros() {
        return membros;
    }

    public void setMembros(List<MembPro> membros) {
        this.membros = membros;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public List<EmpPro> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<EmpPro> empresas) {
        empresas.forEach(empPro -> empPro.setProjeto(this));
        this.empresas = empresas;
    }

    public Date calculateCompletionDate(OrdemServico ordemServico, int duracao) {
        Calendar end = Calendar.getInstance();
        end.setTime(ordemServico.getDataInicio());
        end.add(Calendar.MONTH, duracao);
        return end.getTime();
    }
}
