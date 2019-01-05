package com.tostringtech.refp.core.repositories.dao;

import java.util.List;

import com.tostringtech.refp.core.entities.*;

public interface ProjetoHibernateDAO {


	public List<FaseCadeiaInovacaoProjeto> findAllProjectInovationPhases();

	public List<SubtemaProjeto> findAllProjectSubSubjects(String codTema);


	public List<TemaProjeto> findAllProjectSubjects();


	public List<TipoProduto> findAllProjectProductsTypes();


	void addProjectMember(Long codMembro, Long codProjeto, Long codFuncao, Long codTitulacao);

	void removeProjectMember(Long codMembro, Long codProjeto);

	void inativateProjectMember(Long codMembro, Long codProjeto);

	void addProjectExpense(Long codDespesa, Long codProjeto);

	void removeProjectExpense(Long codDespesa, Long codProjeto);

	public List<TipoProjeto> findAllProjectTypes();

	public List<SegmentoProjeto> findAllProjectSegments();

}
