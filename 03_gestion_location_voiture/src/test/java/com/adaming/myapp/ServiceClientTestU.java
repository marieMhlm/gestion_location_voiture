package com.adaming.myapp;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.dao.IClientDao;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.service.IClientService;

/**
 * Version 1.0
 * 09/09/2016
 * @author inti0255
 *
 */
public class ServiceClientTestU {
	
	private static ClassPathXmlApplicationContext context;
	private static IClientService clientService; 
	
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		clientService = (IClientService) context.getBean("serviceClient");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAdd() throws ParseException {
		Date datebirth = date.parse("13/06/1995");
		Date datePermis = date.parse("21/08/2015");
		Client cl = new Client("Mimi", "Marie", datebirth, "0236548521", "Tours", "mm@gmail.com", datePermis);
		clientService.add(cl, 1L);
		assertTrue(cl!=null);
	}

	@Test
	public void testUpdate() {
		Client cl = clientService.getById(1L);
		cl.setNom("dododo");
		clientService.update(cl);
		Client cl1 = clientService.getById(1L);
		Assert.assertEquals("", "dododo", cl1.getNom());
	}

	@Test
	public void testGetAll() {
		List<Client> c = clientService.getAll(); 
		assertTrue(c.size()>0);
	}

	@Test
	public void testGetById() {
		Client cl = clientService.getById(1L);
		assertTrue(cl!=null);
	}

}
