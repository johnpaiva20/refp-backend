package com.tostringtech.refp.core.services.impl;

import com.tostringtech.refp.api.resources.EnterpriseResource;
import com.tostringtech.refp.api.resources.MemberResource;
import com.tostringtech.refp.api.resources.ProjectEnterpriseResource;
import com.tostringtech.refp.api.resources.ProjectResource;
import com.tostringtech.refp.core.entities.*;
import com.tostringtech.refp.core.entities.relationships.EmpresaProjeto;
import com.tostringtech.refp.core.repositories.ProjetoRepository;
import com.tostringtech.refp.core.services.EmpresaService;
import com.tostringtech.refp.core.services.MembroService;
import com.tostringtech.refp.core.services.ProjetoService;
import com.tostringtech.refp.core.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepositorio;

    @Autowired
    private MembroService membroService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private RecursoService recursoService;


    @Override
    public void addEnterprise(Long codProjeto, EnterpriseResource entrpreise) {
        Projeto projeto = projetoRepositorio.findById(codProjeto).get();
        projeto = empresaService.addProjectEnterprise(projeto, entrpreise);
        projetoRepositorio.save(projeto);
    }

    @Override
    public void delete(Long codProjeto) {
        projetoRepositorio.deleteById(codProjeto);
    }

    @Override
    public void delete(Projeto projeto) {
        projetoRepositorio.delete(projeto);
    }

    @Override
    public Projeto findById(Long codProjeto) {
        Optional<Projeto> projeto = projetoRepositorio.findById(codProjeto);
        return projeto.get();
    }

    @Override
    public ProjectResource create(Projeto projeto) {
        projeto = projetoRepositorio.save(projeto);
        if (projeto != null) {
            return buildProjectResource(projeto);
        }
        return null;
    }

    @Override
    public ProjectResource create(ProjectResource projetoResource) {
        Projeto projeto = buildProjeto(projetoResource);
        projeto = projetoRepositorio.save(projeto);
        if (projeto != null) {
            return buildProjectResource(projeto);
        }
        return null;
    }

    @Override
    public void update(Projeto projeto) {
        projetoRepositorio.save(projeto);
    }

    @Override
    public void update(ProjectResource projetoResource) {
        Projeto projeto = buildProjeto(projetoResource);
        projetoRepositorio.save(projeto);
    }

    @Override
    public List<ProjectResource> findAll() {
        List<ProjectResource> resources = new ArrayList<>();
        projetoRepositorio.findAll().forEach(projeto -> {
            ProjectResource resource = buildProjectResource(projeto);
            resources.add(resource);
        });
        return resources;
    }

    @Override
    public List<MemberResource> findAllProjectMembers(Long codProjeto) {
        return membroService.findByCodProjeto(codProjeto);
    }

    @Override
    public void addProjectMember(Long codMembro, Long codProjeto, Long codFuncao, Long codTitulacao) {
        //TODO
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
    public List<ProjectEnterpriseResource> findAllProjectEnterprises(Long codProjeto) {
        return empresaService.findByCodProjeto(codProjeto);
    }

    @Override
    public Recurso addRecursoProjeto(Recurso recurso) {
        // TODO Auto-generated method stub
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
        return projetoRepositorio.findAllProjectSubSubjects(codTema);
    }

    @Override
    public ProjectResource buildProjectResource(Projeto project) {
        ProjectResource resource = new ProjectResource();

        resource.setId(project.getCodProjeto());
        resource.setAneelId(project.getCodAneel());
        resource.setServiceOrder(project.getDsOrdemServico());
        resource.setTitle(project.getDsTitulo());
        resource.setDuration(project.getVlDuracaoMeses());
        resource.setStartDate(project.getDtInicio());
        resource.setStatus(project.getStatus());

        if (project.getFaseCadeiaInovacao() != null) {
            resource.setInnovationPhase(project.getFaseCadeiaInovacao().getCodFaseCadeia());
        }
        if (project.getProduto() != null) {
            resource.setProduct(project.getProduto().getCodTipoProduto());
        }

        if (project.getSegmento() != null) {
            resource.setSegment(project.getSegmento().getCodSegmento());
        }

        if (project.getTema() != null) {
            resource.setSubject(project.getTema().getDescTema());
        }
        if (project.getSubtema() != null) {
            resource.setSubSubject(project.getSubtema().getCodSubtemaProjeto());
        }
        if (project.getTipoProjeto() != null) {
            resource.setType(project.getTipoProjeto().getDescTipoProjeto());
        }

        return resource;
    }

    @Override
    public ProjectResource buildProjectResource(Long codProjeto) {
        ProjectResource resource = new ProjectResource();
        Projeto projeto = findById(codProjeto);
        return buildProjectResource(projeto);
    }

    @Override
    public Projeto buildProjeto(ProjectResource resource) {
        Projeto projeto = new Projeto();

        projeto.setCodProjeto(resource.getId());
        projeto.setCodAneel(resource.getAneelId());
        projeto.setDsOrdemServico(resource.getServiceOrder());
        projeto.setDsTitulo(resource.getTitle());
        projeto.setVlDuracaoMeses(resource.getDuration());
        projeto.setDtInicio(resource.getStartDate());
        projeto.setStatus(resource.getStatus());

        if (resource.getInnovationPhase() != null) {
            projeto.setFaseCadeiaInovacao(new FaseCadeiaInovacaoProjeto(resource.getInnovationPhase()));
        }
        if (resource.getProduct() != null) {
            projeto.setProduto(new TipoProduto(resource.getProduct()));
        }
        if (resource.getSegment() != null) {
            projeto.setSegmento(new SegmentoProjeto(resource.getSegment()));
        }
        if (resource.getSubject() != null) {
            projeto.setDescTema(new TemaProjeto(resource.getSubject()));
        }
        if (resource.getSubSubject() != null) {
            projeto.setSubtema(new SubtemaProjeto(resource.getSubSubject()));
        }
        if (resource.getType() != null) {
            projeto.setTipoProjeto(new TipoProjeto(resource.getType()));
        }

        return projeto;
    }

    @Override
    public Projeto buildProjeto(File projectXML) {
        //TODO
        DocumentBuilder dBuilder = null;

        try {

            dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(projectXML);
            doc.getElementsByTagName("");

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
