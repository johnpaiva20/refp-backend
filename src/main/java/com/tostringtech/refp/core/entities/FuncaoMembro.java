package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "FUNCAO_MEMBRO")
public class FuncaoMembro {
	
	@Id
    @Column(name = "COD_FUNCAO_MEMBRO")
	private String codFuncaoMembro;

    @Column(name = "DESC_FUNCAO_MEMBRO")
	private String descFuncaoMembro;

    public String getCodFuncaoMembro() {
        return codFuncaoMembro;
    }

    public void setCodFuncaoMembro(String codFuncaoMembro) {
        this.codFuncaoMembro = codFuncaoMembro;
    }

    public String getDescFuncaoMembro() {
        return descFuncaoMembro;
    }

    public void setDescFuncaoMembro(String descFuncaoMembro) {
        this.descFuncaoMembro = descFuncaoMembro;
    }
}
