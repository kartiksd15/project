package com.xworkz.spring.dto;

import org.slf4j.LoggerFactory;

public class EnvDTO {
	private String env;
	private String url ;
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(EnvDTO.class);
	
	public EnvDTO() {
		log.info("created EnvDTO"+this.getClass().getSimpleName());
	}
	
	
	public String getEnv() {
		return env;
	}
	
	public void setEnv(String env) {
		this.env = env;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "EnvDTO [env=" + env + ", url=" + url + "]";
	}
	
	

}
