package com.xworkz.spring.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.spring.entity.AppInfoEntity;
import com.xworkz.spring.entity.AppInfoEvnAddEntity;
import com.xworkz.spring.utility.Utility;

@Repository
public class LoginImplDAO implements LoginDAO {
	
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoginImplDAO.class);
	
	@Autowired
	private Utility utility;
	
	@PostConstruct
	public void init()
	{
		log.info("Invoked initilizer...");
		factory=utility.returnFactory();
	}
	
	
	private SessionFactory factory;
	
	public LoginImplDAO() {
		log.info("created LoginImplDAO"+this.getClass().getSimpleName());
	}
	
	

	@Override
	public String save(AppInfoEntity appInfoEntity, List<AppInfoEvnAddEntity> envlist) {
		
		log.info("Invoked save ... "+this.getClass().getSimpleName());
		String result=null;
		Session session=factory.openSession(); 
		try {
			session.beginTransaction();
			session.save(appInfoEntity);
			log.info("Started looping..");
			log.info("List is : "+envlist);
			for(AppInfoEvnAddEntity addEntity:envlist) {
				log.info("AppInfoEvnAddEntity : "+ addEntity);
				session.save(addEntity);
			}
			session.getTransaction().commit();
			result="data saved in DB successfully";
			
		}catch(Exception e) {
			result="failed to save in DB ";
			session.getTransaction().rollback();
		
			log.error("error in"+this.getClass().getSimpleName());
		}finally {
			session.close();
		}
		
		return result;
	}

}
