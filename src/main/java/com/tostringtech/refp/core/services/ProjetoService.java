package com.tostringtech.refp.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.entities.Recurso;
import com.tostringtech.refp.core.entities.RecursoProjeto;
import com.tostringtech.refp.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepositorio;
	
	@Autowired
	private MembroService  membroService;

	@Autowired
	private RecursoProjetoService  recursoProjetoService;

	
	//Projeto 
	public Projeto create(Projeto projeto) {
		return projetoRepositorio.save(projeto);
	}

	public void delete(Projeto projeto) {
		projetoRepositorio.delete(projeto);
	}

	public Projeto update(Projeto projeto) {
		return projetoRepositorio.save(projeto);
	}

	public Projeto findByCodProjeto(Long codProjeto) {
		Optional<Projeto> p = projetoRepositorio.findById(codProjeto);
		return p.orElse(null);
	}

	public List<Projeto> findAll() {
		return (List<Projeto>) projetoRepositorio.findAll();
	}

	// Membro Projeto

	public List<Membro> findAllProjectMembers(Long codProjeto) {
		return membroService.findByProject(codProjeto);
	}

	public void addProjectMember(Long codMembro, Long codProjeto,String descTitulacao) {
		Projeto projeto = findByCodProjeto(codProjeto);
		Membro membro = membroService.find(codMembro);
		membro.getDescTitulacao().put(projeto, descTitulacao);
		//projeto.getMembros().add(membro);
		update(projeto);
	}
	
	public void removeProjectMember(Long codMembro, Long codProjeto) {
		Projeto projeto = findByCodProjeto(codProjeto);
		Membro membro = membroService.find(codMembro);
		//projeto.getMembros().remove(membro);
		update(projeto);
	}
	
	// Despesa Projeto

	public void addProjectExpense(Despesa despesa, Long codProjeto) {
		Projeto projeto = findByCodProjeto(codProjeto);
		//projeto.getDespesas().add(despesa);
		update(projeto);
	}

	public void removeProjectExpense(Despesa despesa, Long codProjeto) {
		Projeto projeto = findByCodProjeto(codProjeto);
		//projeto.getDespesas().remove(despesa);
		update(projeto);
	}
   //Empresas Projeto
	public void addEnterprise(Long codProjeto,Long codEmpresa, String tpEmpresa) {
		Projeto projeto = findByCodProjeto(codProjeto);
		update(projeto);
	}

	public void removeEnterprise(Long codEmpresa, Long codProjeto) {
		Projeto projeto = findByCodProjeto(codProjeto);
		update(projeto);
	}

	//Recursos projeto
	public RecursoProjeto addRecursoProjeto(Long codProjeto, RecursoProjeto recurso) {
		RecursoProjetoService recProjService = new RecursoProjetoService();
		
		Projeto projeto = findByCodProjeto(codProjeto);
		recurso.setProjeto(projeto);
		//recurso = new RecursoService().create(recurso);
		
		//RecursoProjeto recProjeto = new RecursoProjeto();

		//recProjeto.setProjeto(projeto);
		//recProjeto.setRecurso(recurso);
		//recProjeto.setValorRecurso(valorRecurso);
		
//		return recProjService.create(recProjeto);
		return recProjService.create(recurso);
	}
}
