package com.tostringtech.refp.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity()
public class FuncaoMembro {
	
	@Id
	private String codFuncaoMembro;
	
	@Column
	private String descFuncaoMembro;

}
