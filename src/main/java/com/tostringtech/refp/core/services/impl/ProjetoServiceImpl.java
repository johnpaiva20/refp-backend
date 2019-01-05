package com.tostringtech.refp.core.services.impl;

import java.util.List;
import java.util.Optional;

import com.tostringtech.refp.core.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tostringtech.refp.core.repositories.ProjetoRepository;
import com.tostringtech.refp.core.services.MembroService;
import com.tostringtech.refp.core.services.ProjetoService;
import com.tostringtech.refp.core.services.RecursoService;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepositorio;

    @Autowired
    private MembroService membroService;



    @Autowired
    private RecursoService recursoService;


    @Override
    public void delete(Long codProjeto) {
        Projeto p = findByCod(codProjeto);
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
        return membroService.findByCodProjeto(codProjeto);
    }

    @Override
    public void addProjectMember(Long codMembro, Long codProjeto, Long codFuncao, Long codTitulacao) {
        projetoRepositorio.addProjectMember(codMembro, codProjeto, codFuncao, codTitulacao);

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
    public Recurso addRecursoProjeto(Recurso recurso) {


        return null;
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

    @Override
    public List<TipoProjeto> findAllProjectTypes() {
        return projetoRepositorio.findAllProjectTypes();
    }

    @Override
    public List<TemaProjeto> findAllProjectSubjects() {
        return projetoRepositorio.findAllProjectSubjects();
    }

    @Override
    public List<SubtemaProjeto> findAllProjectSubSubjects(String codTema) {
        return  projetoRepositorio.findAllProjectSubSubjects(codTema);
    }
}
