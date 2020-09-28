package com.xworkz.spring.dto;

import java.io.Serializable;



public class HomeDTO implements Serializable{
	
	private String name;
	private String message;
	
	public HomeDTO() {
		System.out.println("created..."+this.getClass().getSimpleName());
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
