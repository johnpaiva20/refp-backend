package com.tostringtech.refp.projeto.core.service;

import com.tostringtech.refp.application.exceptions.StandardException;
import com.tostringtech.refp.application.models.*;
import com.tostringtech.refp.projeto.api.repository.ProjetoRepository;
import com.tostringtech.refp.projeto.api.rest.filters.TopicFilter;
import com.tostringtech.refp.projeto.api.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    /**
     * Cadastro de Projeto
     *
     * @param projeto
     * @return Projeto cadastrado
     */
    @Override
    public Projeto create(Projeto projeto) {

        if (projeto.getTitulo().length() > 200) {
            throw new StandardException("Título não deve ultrapassar 200 caracteres");
        }
        if (projeto.getTema() == null) {
            throw new StandardException("Deve-se selecionar o tema do projeto");
        }

        if (projeto.getDuracao() > 48) {
            throw new StandardException("Duração não deve ultrapassar 48 meses");
        }
        if (projeto.getOrdemServico().getOrdem().length() > 20) {
            throw new StandardException("Ordem de serviço não deve ultrapassar 20 caracteres");
        }
        return projetoRepository.save(projeto);

    }

    @Override
    public List<Projeto> findAll(Pageable pageable) {
        return projetoRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Subtema> findAllSubtopicsByTopic(Long topic) {
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
    public List<Tema> findAllTopicsByProjectType(TopicFilter filter) {
        return projetoRepository.findAllTopicsByProjectType(filter);
    }

    @Override
    public List<TipoProduto> listProductTypes() {
        return this.projetoRepository.listProductsTypes();
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
