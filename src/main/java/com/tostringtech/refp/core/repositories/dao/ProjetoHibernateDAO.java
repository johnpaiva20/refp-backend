package com.tostringtech.refp.core.repositories.dao;

import java.util.List;

import com.tostringtech.refp.core.entities.FaseCadeiaInovacaoProjeto;
import com.tostringtech.refp.core.entities.SegmentoProjeto;
import com.tostringtech.refp.core.entities.SubtemaProjeto;
import com.tostringtech.refp.core.entities.TemaProjeto;
import com.tostringtech.refp.core.entities.TipoProduto;
import com.tostringtech.refp.core.entities.TipoProjeto;

public interface ProjetoHibernateDAO {
	

	public List<FaseCadeiaInovacaoProjeto> findAllProjectInovationPhases();

	public List<SubtemaProjeto> findAllProjectSubsubjects();

	public List<TemaProjeto> findAllProjectSubjects();

	public List<TipoProduto> findAllProjectProductsTypes();

	public List<TipoProjeto> findAllProjectTypes();

	public List<SegmentoProjeto> findAllProjectSegments();
}
