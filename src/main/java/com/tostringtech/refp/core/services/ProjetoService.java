package com.tostringtech.refp.core.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.PropertyResolverExtensionsKt;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.entities.Despesa;
import com.tostringtech.refp.core.entities.Empresa;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.repositories.EmpresaRepository;
import com.tostringtech.refp.repositories.MembroRepository;
import com.tostringtech.refp.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepositorio;

	@Autowired
	private MembroService membroService;
	
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

	public Projeto find(Long codProjeto) {
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

	public void addProjectMember(Membro membro, Long codProjeto) {
		Projeto projeto = find(codProjeto);
		projeto.getMembros().add(membro);
		update(projeto);
	}

	public void removeProjectMember(Membro membro, Long codProjeto) {
		Projeto projeto = find(codProjeto);
		projeto.getMembros().remove(membro);
		update(projeto);
	}

	// Despesa Projeto

	public void addProjectExpense(Despesa despesa, Long codProjeto) {
		Projeto projeto = find(codProjeto);
		projeto.getDespesas().add(despesa);
		update(projeto);
	}

	public void removeProjectExpense(Despesa despesa, Long codProjeto) {
		Projeto projeto = find(codProjeto);
		projeto.getDespesas().remove(despesa);
		update(projeto);
	}
   //Empresas Projeto
	public void addEnterprise(Long codProjeto,Long codEmpresa, String tpEmpresa) {
		Projeto projeto = find(codProjeto);
		update(projeto);
	}

	public void removeEnterprise(Long codEmpresa, Long codProjeto) {
		Projeto projeto = find(codProjeto);
		update(projeto);
	}

}
