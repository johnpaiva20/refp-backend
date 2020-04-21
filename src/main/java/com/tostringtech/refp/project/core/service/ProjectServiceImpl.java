package com.tostringtech.refp.project.core.service;

import com.tostringtech.refp.application.exceptions.StandardException;
import com.tostringtech.refp.application.models.EmpPro;
import com.tostringtech.refp.application.models.OrdemServico;
import com.tostringtech.refp.application.models.Projeto;
import com.tostringtech.refp.project.api.repository.ProjectRepository;
import com.tostringtech.refp.project.api.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Projeto create(Projeto projeto) throws StandardException {

        if (projeto.getTitulo() != null) {

            if (projeto.getTitulo().length() > 200)
                throw new StandardException("Título não deve ultrapassar 200 caracteres");

        } else {
            throw new StandardException("Titulo deve ser preenchido");
        }

        if (projeto.getCodigoAneel() == null)
            throw new StandardException("Código ANEEL deve ser preenchido");

        if (projeto.getOrdemServico() != null) {
            OrdemServico ordemServico = projeto.getOrdemServico();

            if (ordemServico.getNumero() == null)
                throw new StandardException("Número da ordem de serviço deve ser preenchida");
            else if (ordemServico.getNumero().length() > 100)
                throw new StandardException("Ordem de serviço não deve ultrapassar 100 caracteres");

            if (ordemServico.getDataInicio() == null)
                throw new StandardException("Data de inicio deve ser preenchida");

            if (ordemServico.getDuracao() == 0)
                throw new StandardException("Duração não pode ser de nenhum mês ");
            else if (ordemServico.getDuracao() > 48)
                throw new StandardException("Duração não deve ultrapassar 48 meses");

        }
        return projectRepository.save(projeto);

    }

    @Override
    public Long countProjects() {
        return projectRepository.count();
    }

    @Override
    public void addEnterprises(List<EmpPro> empresas, Long id) {
        if (this.findById(id).isPresent()) {
            throw new StandardException("Projeto não encontrado");
        }
        Projeto projeto = this.findById(id).get();
        empresas.forEach(empPro -> empPro.setProjeto(projeto));
        projeto.getEmpresas().addAll(empresas);
        this.projectRepository.save(projeto);
    }

    @Override
    public List<EmpPro> findAllProjectEnterprises(Long id) {
        if (this.findById(id).isPresent()) {
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
    public int getTotalProjectPages(Pageable pageable) {
        return projectRepository.findAll(pageable).getTotalPages();
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
    public void delete(Projeto projeto) {
        projectRepository.delete(projeto);
    }

}
