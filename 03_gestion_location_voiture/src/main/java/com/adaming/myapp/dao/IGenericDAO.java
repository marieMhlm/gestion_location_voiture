package com.adaming.myapp.dao;

import java.util.List;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
public interface IGenericDAO<T> {

	public T add(T t);
	
	public T update(T t);
	
	public List<T> getAll();
	
	public T getById(Long pId);
	
}
