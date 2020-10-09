package com.xworkz.spring.dto;

import java.io.Serializable;

import org.slf4j.LoggerFactory;

import com.xworkz.spring.controller.HomeController;

public class HomeDTO implements Serializable{
	
	private Integer id;
	private String name;
	private String message;
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	public HomeDTO() {
		LOGGER.info("created HomeDTO");
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	

}
