package com.tostringtech.refp.projeto.service.impl;

import com.tostringtech.refp.application.model.Projeto;
import com.tostringtech.refp.application.model.Subtema;
import com.tostringtech.refp.application.model.Tema;
import com.tostringtech.refp.projeto.repository.ProjetoRepository;
import com.tostringtech.refp.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

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
    public List<Tema> findAllTopicsByProjectType(String type){
       return projetoRepository.findAllTopicsByProjectType(type);
    }


}
