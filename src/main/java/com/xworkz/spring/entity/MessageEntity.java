package com.xworkz.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.LoggerFactory;


@Entity // This tells Hibernate to make a table out of this class
public class MessageEntity {
	
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String message;
	
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MessageEntity.class);
	
	public MessageEntity() {
		LOGGER.info("created MessageEntity"+this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	

}
