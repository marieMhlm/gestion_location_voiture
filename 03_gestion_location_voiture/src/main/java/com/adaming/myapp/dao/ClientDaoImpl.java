package com.adaming.myapp.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.entities.Client;

/**
 * Version 1.0
 * 06/09/2016
 * @author inti0255
 *
 */
@Repository("clientDao")
public class ClientDaoImpl extends GenericDaoImpl<Client> implements IClientDao{
	

}
