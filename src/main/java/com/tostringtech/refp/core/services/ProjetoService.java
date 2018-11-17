package com.tostringtech.refp.core.services;

import java.util.List;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.entities.RecursoProjeto;

public interface ProjetoService extends IServices<Projeto> {
	// Projeto
	public Projeto create(Projeto projeto);

	public Projeto update(Projeto projeto);

	public List<Projeto> findAll();

	// Membro
	public List<Membro> findAllProjectMembers(Long codProjeto);

	public void addProjectMember(Long codMembro, Long codProjeto, String descTitulacao);

	public void removeProjectMember(Long codMembro, Long codProjeto);

	// Despesa
	public void addProjectExpense(Despesa despesa, Long codProjeto);
	public void removeProjectExpense(Despesa despesa, Long codProjeto);
	//Empresa
	public void addEnterprise(Long codProjeto,Long codEmpresa, String tpEmpresa);
	// Recurso
	public RecursoProjeto addRecursoProjeto(Long codProjeto, RecursoProjeto recurso);

}