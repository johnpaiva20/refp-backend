package com.tostringtech.refp.project.core.service;

import com.tostringtech.refp.application.exceptions.StandardException;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.application.models.TipoProjeto;
import com.tostringtech.refp.project.api.repository.ProjectRepository;
import com.tostringtech.refp.project.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Cadastro de Projeto
     *
     * @param  projeto - Projeto
     * @return Projeto
     */
    @Override
    public Projeto create(Projeto projeto) {

        if (projeto.getTitulo() != null) {
            if (projeto.getTitulo().length() > 200) {
                throw new StandardException("Título não deve ultrapassar 200 caracteres");
            }

        } else {
            throw new StandardException("Titulo deve ser preenchido");
        }

        if (projeto.getDuracao() > 48) {
            throw new StandardException("Duração não deve ultrapassar 48 meses");
        }

        if (projeto.getOrdemServico() != null) {
            if (projeto.getOrdemServico().getOrdem().length() > 100) {
                throw new StandardException("Ordem de serviço não deve ultrapassar 100 caracteres");
            }
        }
        return projectRepository.save(projeto);

    }

    @Override
    public List<Projeto> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Projeto> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Projeto update(Projeto projeto) {
        //TODO
        return null;
    }

    @Override
    public Projeto delete(Projeto projeto) {
        //TODO
        return null;
    }

    @Override
    public List<TipoProjeto> listAllProjectTypes() {
        return projectRepository.listAllProjectTypes();
    }


}
