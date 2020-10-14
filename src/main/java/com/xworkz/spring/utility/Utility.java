package com.xworkz.spring.utility;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Utility {
	
	@Autowired
	private EntityManagerFactory factory;
	

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Utility.class);
	
//	
//	When the application has finished using the entity managerfactory, and/or at application shutdown,
//	the application shouldclose the entity manager factory.
//	Once an EntityManagerFactory has been closed, 
//	all its entity managersare considered to be in the closed state.
	
	public SessionFactory returnFactory()
	{
		log.info("Factory value is : "+factory);
		return factory.unwrap(SessionFactory.class);
		 
	}

}
