package com.xworkz.spring.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.spring.entity.MessageEntity;
import com.xworkz.spring.repository.RepositoryMessage;
@Service
public class ServiceMessage {
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MessageEntity.class);
	
	@Autowired
	private RepositoryMessage repositoryMessage;
	
	public ServiceMessage() {
		LOGGER.info(this.getClass().getSimpleName()+"created");
	}
	
	public void save(MessageEntity messageEntity) {
		LOGGER.info(this.getClass().getSimpleName()+"created");
		repositoryMessage.save(messageEntity);
	}

}
