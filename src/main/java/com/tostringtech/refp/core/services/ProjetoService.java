package com.tostringtech.refp.core.services;

import java.util.List;

import com.tostringtech.refp.core.entities.*;

public interface ProjetoService extends IServices<Projeto> {
	// Projeto

	/**
	 *
	 * @param projeto
	 * @return Cria um Projeto e salva no banco de dados
	 */
	public Projeto create(Projeto projeto);

	public Projeto update(Projeto projeto);

	public List<Projeto> findAll();

	// Membro
	public List<Membro> findAllProjectMembers(Long codProjeto);
	public void addProjectMember(Long codMembro, Long codProjeto, Long codFuncao,Long codTitulacao);
	public void removeProjectMember(Long codMembro, Long codProjeto);

	// Despesa
	public void addProjectExpense(Despesa despesa, Long codProjeto);
	public void removeProjectExpense(Despesa despesa, Long codProjeto);
	
	//Empresa
	public void addEnterprise(Long codProjeto,Long codEmpresa, String tpEmpresa);
	
	// Recurso
	public Recurso addRecursoProjeto(Recurso recurso);
    
	//SegmentoProjeto
	List<SegmentoProjeto> findAllProjectSegments();
	
	//TipoProduto
	List<TipoProduto> findAllProjectProductsTypes();

	List<FaseCadeiaInovacaoProjeto> findAllProjectInovationPhases();

	List<TipoProjeto> findAllProjectTypes();

	List<TemaProjeto> findAllProjectSubjects();

	List<SubtemaProjeto>findAllProjectSubSubjects(String codTema);

}