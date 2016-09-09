package com.adaming.myapp.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
public abstract class GenericDaoImpl<T> implements IGenericDAO<T> {
	
	@PersistenceContext
	protected EntityManager em; 
	
	Logger log = Logger.getLogger("GenericDaoImpl");
	
	private Class<T> type; 
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(){
		Type t = getClass().getGenericSuperclass(); 
		ParameterizedType pt = (ParameterizedType) t; 
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T add(T t) {
		this.em.persist(t);
		log.info("C'est bien �t� ajout� ");
		return t;
	}

	@Override
	public T update(T t) {
		this.em.merge(t);
		log.info("C'est bien �t� modifi� ");
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		Query query = em.createQuery("from " +type.getSimpleName());
		log.info("il existe "+ query.getResultList().size() +" dans la base de donn�es ");
		return query.getResultList();
	}

	@Override
	public T getById(Long pId) {
		T t = this.em.find(type, pId);
		log.info("C'est bien �t� trouv� ");
		return t;
	}

}
