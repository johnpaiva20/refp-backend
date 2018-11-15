package com.tostringtech.refp.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepositorio;
	
	@Autowired
	private MembroService  membroService;

	//Projeto 
	public Projeto create(Projeto projeto) {
		return projetoRepositorio.save(projeto);
	}

	public void delete(Projeto projeto) {
		projetoRepositorio.delete(projeto);
	}

	public void update(Projeto projeto) {
		projetoRepositorio.save(projeto);
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

}
