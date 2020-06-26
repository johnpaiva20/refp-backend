package com.tostringtech.refp.application.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tostringtech.refp.project.api.enums.ProjectType;
import com.tostringtech.refp.project.api.resources.ProjectResource;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

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
    
    @Column(name = "RB_RH")
    @Value("0")
    private Double rbRH;
    
    @Column(name = "RB_MAT_PERM")
    @Value("0")
    private Double rbMateriaisPermanentes;

    @Column(name = "RB_MAT_CONS")
    @Value("0")
    private Double rbMateriaisConsumo;

    @Column(name = "RB_SERV_TERC")
    @Value("0")
    private Double rbServicoTerceiros;
    
    @Column(name = "RB_VIA_DIA")
    @Value("0")
    private Double rbViagensDiarias;

    @Column(name = "RB_OUTROS")
    @Value("0")
    private Double rbOutros;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CD_ORDEM_SERVICO", nullable = false)
    private OrdemServico ordemServico;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CD_DESPESA")
    private Empresa empresa;

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
        this.setRbRH(resource.getRbRH());
        this.setRbMateriaisPermanentes(resource.getRbMatPerm());
        this.setRbMateriaisConsumo(resource.getRbMatCons());
        this.setRbServicoTerceiros(resource.getRbServTerc());
        this.setRbViagensDiarias(resource.getRbViaDia());
        this.setRbOutros(resource.getRbOutros());
        if (resource.getMainEnterprise() != null) {        	
        	this.setEmpresa(new Empresa(resource.getMainEnterprise()));
        }
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

    public Double getRbRH() {
		return rbRH;
	}

	public void setRbRH(Double rbRH) {
		this.rbRH = rbRH;
	}

	public Double getRbMateriaisPermanentes() {
		return rbMateriaisPermanentes;
	}

	public void setRbMateriaisPermanentes(Double rbMateriaisPermanentes) {
		this.rbMateriaisPermanentes = rbMateriaisPermanentes;
	}

	public Double getRbMateriaisConsumo() {
		return rbMateriaisConsumo;
	}

	public void setRbMateriaisConsumo(Double rbMateriaisConsumo) {
		this.rbMateriaisConsumo = rbMateriaisConsumo;
	}

	public Double getRbServicoTerceiros() {
		return rbServicoTerceiros;
	}

	public void setRbServicoTerceiros(Double rbServicoTerceiros) {
		this.rbServicoTerceiros = rbServicoTerceiros;
	}

	public Double getRbViagensDiarias() {
		return rbViagensDiarias;
	}

	public void setRbViagensDiarias(Double rbViagensDiarias) {
		this.rbViagensDiarias = rbViagensDiarias;
	}

	public Double getRbOutros() {
		return rbOutros;
	}

	public void setRbOutros(Double rbOutros) {
		this.rbOutros = rbOutros;
	}

	public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
