package com.tostringtech.refp.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Projeto")
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(hidden = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProjeto;

	@ApiModelProperty()
	@Column(nullable = false, unique = true)
	private String codAneel;

	@ApiModelProperty()
	@Column(nullable = false)
	private String dsTitulo;

	@ApiModelProperty()
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtInicio;

	@ApiModelProperty()
	@Column(nullable = false)
	private int vlDuracaoMeses;

	@Column(nullable = false, unique = true)
	@ApiModelProperty()
	private String dsOrdemServico;

	@Column(nullable = false)
	@ApiModelProperty()
	private String status;

	@ManyToOne()
	@ApiModelProperty()
	@JoinColumn(name = "codTipoProjeto")
	@JsonIgnoreProperties(value = { "snAtivo" })
	private TipoProjeto codTipoProjeto;

	/*
	 * @ManyToOne()
	 * 
	 * @ApiModelProperty() private TemaProjeto temaProjeto;
	 * 
	 * @ManyToOne()
	 * 
	 * @ApiModelProperty() private SubtemaProjeto subtemaProjeto;
	 * 
	 * @ManyToOne()
	 * 
	 * @ApiModelProperty() private SegmentoProjeto segmentoProjeto;


	@JsonIgnore
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "membro", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<MembrosProjeto> membrosProjeto = new HashSet<>();

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EmpresasProjeto> empresasProjeto = new HashSet<>();

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "despesa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DespesasProjeto> despesasProjeto = new ArrayList<>();

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RecursoProjeto> recursosProjeto = new ArrayList<RecursoProjeto>();
*/
	
	public Projeto() {

	}

	public Projeto(Long codProjeto, String cdAneel, String dsTitulo, Date dtInicio, int vlDuracaoMeses,
			String dsOrdemServico, String status) {
		this.codProjeto = codProjeto;
		this.codAneel = cdAneel;
		this.dsTitulo = dsTitulo;
		this.dtInicio = dtInicio;
		this.vlDuracaoMeses = vlDuracaoMeses;
		this.dsOrdemServico = dsOrdemServico;
		this.status = status;
	}

	public Long getCodProjeto() {
		return codProjeto;
	}

	public void setCodProjeto(Long codProjeto) {
		this.codProjeto = codProjeto;
	}

	public String getCodAneel() {
		return codAneel;
	}

	public void setCodAneel(String codAneel) {
		this.codAneel = codAneel;
	}

	public String getDsTitulo() {
		return dsTitulo;
	}

	public void setDsTitulo(String dsTitulo) {
		this.dsTitulo = dsTitulo;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public int getVlDuracaoMeses() {
		return vlDuracaoMeses;
	}

	public void setVlDuracaoMeses(int vlDuracaoMeses) {
		this.vlDuracaoMeses = vlDuracaoMeses;
	}

	public String getDsOrdemServico() {
		return dsOrdemServico;
	}

	public void setDsOrdemServico(String dsOrdemServico) {
		this.dsOrdemServico = dsOrdemServico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TipoProjeto getCodTipoProjeto() {
		return codTipoProjeto;
	}

	public void setCodTipoProjeto(TipoProjeto codTipoProjeto) {
		this.codTipoProjeto = codTipoProjeto;
	}


}
