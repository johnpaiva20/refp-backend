package com.tostringtech.refp.core.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.entities.FaseCadeiaInovacaoProjeto;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.entities.Recurso;
import com.tostringtech.refp.core.entities.RecursoProjeto;
import com.tostringtech.refp.core.entities.RecursoProjetoId;
import com.tostringtech.refp.core.entities.SegmentoProjeto;
import com.tostringtech.refp.core.entities.TipoProduto;
import com.tostringtech.refp.core.repositories.ProjetoRepository;
import com.tostringtech.refp.core.services.MembroService;
import com.tostringtech.refp.core.services.ProjetoService;
import com.tostringtech.refp.core.services.RecursoProjetoService;
import com.tostringtech.refp.core.services.RecursoService;

@Service
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepositorio;
	
	@Autowired
	private MembroService  membroService;

	@Autowired
	private RecursoProjetoService  recursoProjetoService;

	@Autowired
	private RecursoService  recursoService;
	
	@Override
	public void delete(Long codProjeto) {
		Projeto p= findByCod(codProjeto);
		projetoRepositorio.delete(p);
	}

	@Override
	public Projeto findByCod(Long codProjeto) {
		Optional<Projeto> p = projetoRepositorio.findById(codProjeto);
		return p.orElse(null);
	}

	@Override
	public Projeto create(Projeto projeto) {
		return projetoRepositorio.save(projeto);
	}

	@Override
	public Projeto update(Projeto projeto) {
		return projetoRepositorio.save(projeto);
	}

	@Override
	public List<Projeto> findAll() {
		return (List<Projeto>) projetoRepositorio.findAll();
	}

	@Override
	public List<Membro> findAllProjectMembers(Long codProjeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProjectMember(Long codMembro, Long codProjeto, String descTitulacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProjectMember(Long codMembro, Long codProjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProjectExpense(Despesa despesa, Long codProjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProjectExpense(Despesa despesa, Long codProjeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEnterprise(Long codProjeto, Long codEmpresa, String tpEmpresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RecursoProjeto addRecursoProjeto(RecursoProjeto recursoProjeto) {
		Projeto projeto = projetoRepositorio.findById(recursoProjeto.getProjeto().getCodProjeto()).get();
		recursoProjeto.setProjeto(projeto);
		Recurso recurso = recursoService.findByCod(recursoProjeto.getRecurso().getCodRecurso());
		recursoProjeto.setRecurso(recurso);
		
		RecursoProjetoId recProjId = new RecursoProjetoId();
		recProjId.setCodProjeto(projeto.getCodProjeto());
		recProjId.setCodRecurso(recurso.getCodRecurso());
		
		recursoProjeto.setCodRecursosProjeto(recProjId);
		
		return recursoProjetoService.create(recursoProjeto);
	}
	
	@Override
	public List<SegmentoProjeto> findAllProjectSegments() {
		return projetoRepositorio.findAllProjectSegments();
	}
	
	@Override
	public List<TipoProduto> findAllProjectProductsTypes() {
		return projetoRepositorio.findAllProjectProductsTypes();
	}
	@Override
	public List<FaseCadeiaInovacaoProjeto> findAllProjectInovationPhases() {
		return projetoRepositorio.findAllProjectInovationPhases();
	}
}
