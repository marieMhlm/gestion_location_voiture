package com.adaming.myapp;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.dao.IClientDao;
import com.adaming.myapp.entities.Client;

public class ServiceClientTestU {
	
	private static ClassPathXmlApplicationContext context;
	private static IClientDao clientService; 
	
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		clientService = (IClientDao) context.getBean("serviceClient");
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
		clientService.add(cl);
		assertTrue(cl!=null);
	}

	@Test
	@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetById() {
		fail("Not yet implemented");
	}

}
