package com.tostringtech.refp.project.core.service;

import com.tostringtech.refp.application.exceptions.StandardException;
import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.OrdemServico;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.project.api.repository.ProjectRepository;
import com.tostringtech.refp.project.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
     * @param projeto - Projeto
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

        if (projeto.getOrdemServico() != null) {
            OrdemServico ordemServico = projeto.getOrdemServico();

            if (ordemServico.getOrdem().length() > 100) {
                throw new StandardException("Ordem de serviço não deve ultrapassar 100 caracteres");
            }

            if (ordemServico.getDuracao() > 48) {
                throw new StandardException("Duração não deve ultrapassar 48 meses");
            }
        }
        return projectRepository.save(projeto);

    }

    @Override
    public List<Projeto> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void addEnterprises(List<EmpPro> empresas, Long id) {
        if (this.findById(id).isEmpty()) {
            throw new StandardException("Projeto não encontrado");
        }
        Projeto projeto = this.findById(id).get();
        empresas.forEach(empPro -> empPro.setProjeto(projeto));
        projeto.getEmpresas().addAll(empresas);
        this.projectRepository.save(projeto);
    }

    @Override
    public List<EmpPro> findAllProjectEnterprises(Long id) {
        if (this.findById(id).isEmpty()) {
            throw new StandardException("Projeto não encontrado");
        }
        Projeto projeto = this.findById(id).get();
        return projeto.getEmpresas();
    }

    @Override
    public List<Projeto> findAll(Pageable pageable) {
        return projectRepository.findAll(pageable).toList();
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
        projectRepository.delete(projeto);
        return null;
    }

}
