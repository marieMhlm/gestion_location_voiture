package com.adaming.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Voiture;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
@Repository
public class VoitureDaoImpl extends GenericDaoImpl<Voiture> implements IVoitureDao {
	

}
