package com.tostringtech.refp.core.services;

import java.util.List;

public interface IServices <T>{

	public T create(T obj);
	public T update(T obj) ;
	public void delete(Long codObj); 
	public T findByCod(Long codObj);
	public List<T> findAll();
	
}
