package com.tostringtech.refp.projeto.core.service;

import com.tostringtech.refp.application.model.*;
import com.tostringtech.refp.projeto.api.repository.ProjetoRepository;
import com.tostringtech.refp.projeto.api.rest.filters.ProjectTypeFilter;
import com.tostringtech.refp.projeto.api.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    /**
     * Cadastro de Projeto
     * @param projeto
     * @return Projeto cadastrado
     */
    @Override
    public Projeto create(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    @Override
    public List<Subtema> findAllSubtopicsByTopic(String topic) {
        return projetoRepository.findAllSubtopicsByTopic(topic);
    }

    @Override
    public Optional<Projeto> findById(Long id) {
        return projetoRepository.findById(id);
    }

    @Override
    public Page<Projeto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        //TODO
        return null;
    }

    @Override
    public Projeto update(Projeto projeto) {
        //TODO
        return null;
    }

    @Override
    public List<TipoProjeto> listAllProjectTypes() {
        return this.projetoRepository.listAllProjectTypes();
    }

    @Override
    public List<Tema> findAllTopicsByProjectType(ProjectTypeFilter filter){
        return projetoRepository.findAllTopicsByProjectType(filter);
    }

    public Date calculateCompletionDate(Projeto projeto){
        Calendar end = Calendar.getInstance();
        end.setTime(projeto.getOrdemServico().getDataInicio());
        end.add(Calendar.DAY_OF_YEAR,projeto.getDuracao());
        return end.getTime();
    }

    /*@Override
    public List<Segmento> listAllSegments() {
        return this.projetoRepository.listAllSegments();
    }

    @Override
    public List<Produto> listAllProductsTypes() {
        return this.projetoRepository.listAllProductsTypes();
    }

    @Override
    public List<FaseInova> listAllInnovationPhases() {
        return this.projetoRepository.listAllInnovationPhases();
    }*/


}
