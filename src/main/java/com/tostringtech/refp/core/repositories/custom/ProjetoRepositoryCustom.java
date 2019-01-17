package com.tostringtech.refp.core.repositories.custom;

import java.util.List;

import com.tostringtech.refp.core.entities.*;
import org.springframework.data.repository.CrudRepository;

public interface ProjetoRepositoryCustom {


    List<FaseCadeiaInovacaoProjeto> findAllProjectInovationPhases();

    List<SubtemaProjeto> findAllProjectSubSubjects(String codTema);

    List<TemaProjeto> findAllProjectSubjects();

    List<TipoProduto> findAllProjectProductsTypes();

    List<TipoProjeto> findAllProjectTypes();

    List<SegmentoProjeto> findAllProjectSegments();

    void addProjectMember(Long codMembro, Long codProjeto, Long codFuncao, Long codTitulacao);

    void removeProjectMember(Long codMembro, Long codProjeto);

    void inativateProjectMember(Long codMembro, Long codProjeto);

    void addProjectExpense(Long codDespesa, Long codProjeto);

    void removeProjectExpense(Long codDespesa, Long codProjeto);


}
