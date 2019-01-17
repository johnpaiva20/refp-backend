package com.tostringtech.refp.core.entities.relationships;

import com.tostringtech.refp.core.entities.FuncaoMembro;
import com.tostringtech.refp.core.entities.Membro;
import com.tostringtech.refp.core.entities.Projeto;
import com.tostringtech.refp.core.entities.TitulacaoMembro;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MEMBRO_PROJETO", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"COD_MEMBRO", "COD_PROJETO", "COD_FUNCAO_MEMBRO", "COD_FUNCAO_MEMBRO", "COD_TITULACAO"}, name = "MEMBRO_PROJETO_UK_1")})
public class MembroProjeto implements Serializable {

    @Id
    @ManyToOne(targetEntity = Membro.class)
    @JoinColumn(name = "COD_MEMBRO", foreignKey = @ForeignKey(name = "MEMBRO_PROJETO_MEMBRO_FK"))
    private Membro membro;

    @Id
    @ManyToOne(targetEntity = Projeto.class)
    @JoinColumn(name = "COD_PROJETO", foreignKey = @ForeignKey(name = "MEMBRO_PROJETO_PROJETO_FK"))
    private Projeto projeto;

    @ManyToOne(targetEntity = FuncaoMembro.class)
    @JoinColumn(name = "COD_FUNCAO_MEMBRO", foreignKey = @ForeignKey(name = "MEMBRO_PROJETO_FUNCAO_MEMBRO_FK"))
    private FuncaoMembro funcao;

    @ManyToOne(targetEntity = TitulacaoMembro.class)
    @JoinColumn(name = "COD_TITULACAO", foreignKey = @ForeignKey(name = "MEMBRO_PROJETO_TITULACAO_FK"))
    private TitulacaoMembro titulacao;

    @Column(name = "SN_ATIVO")
    private String snAtivo;

    public MembroProjeto() {
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public FuncaoMembro getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoMembro funcao) {
        this.funcao = funcao;
    }

    public TitulacaoMembro getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(TitulacaoMembro titulacao) {
        this.titulacao = titulacao;
    }

    public String getSnAtivo() {
        return snAtivo;
    }

    public void setSnAtivo(String snAtivo) {
        this.snAtivo = snAtivo;
    }
}
