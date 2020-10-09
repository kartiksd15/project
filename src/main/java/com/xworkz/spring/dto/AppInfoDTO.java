package com.xworkz.spring.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.LoggerFactory;



public class AppInfoDTO  implements Serializable{
	private String projectName;
	private String version;
	private String teamManager;
	private String email;
	private Date lastRelease;
	private Date nextRelease;
	private String deComm;
	private Date developDate;
	private String env;
	private String url;
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AppInfoDTO.class);
	
	public AppInfoDTO() {
		LOGGER.info("created appinfoDTO..."+this.getClass().getSimpleName());
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTeamManager() {
		return teamManager;
	}
	public void setTeamManager(String teamManager) {
		this.teamManager = teamManager;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLastRelease() {
		return lastRelease;
	}
	public void setLastRelease(Date lastRelease) {
		this.lastRelease = lastRelease;
	}
	public Date getNextRelease() {
		return nextRelease;
	}
	public void setNextRelease(Date nextRelease) {
		this.nextRelease = nextRelease;
	}
	public String getDeComm() {
		return deComm;
	}
	public void setDeComm(String deComm) {
		this.deComm = deComm;
	}
	public Date getDevelopDate() {
		return developDate;
	}
	public void setDevelopDate(Date developDate) {
		this.developDate = developDate;
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

}
