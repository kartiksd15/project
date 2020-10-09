package com.xworkz.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.LoggerFactory;

import com.xworkz.spring.dto.AppInfoDTO;

@Entity
@Table(name="AppInfo_Table")
public class AppInfoEntity implements Serializable{
	
	@Id
	@Column(name= "Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="Proj_Name")
	private String projectName;
	@Column(name="Version")
	private String version;
	@Column(name="TeamManeger")
	private String teamManager;
	@Column(name="email")
	private String email;
	@Column(name="L_Date")
	private Date lastRelease;
	@Column(name="N_Date")
	private Date nextRelease;
	@Column(name="De_comm")
	private String deComm;
	@Column(name="Dev_Date")
	private Date developDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "appInfoEntity")
	private List<AppInfoEvnAddEntity> appInfoEnvAddEntity;
	
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AppInfoDTO.class);
	
	public AppInfoEntity() {
		LOGGER.info("created AppInfoEntity..."+this.getClass().getSimpleName());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<AppInfoEvnAddEntity> getAppInfoEnvAddEntity() {
		return appInfoEnvAddEntity;
	}

	public void setAppInfoEnvAddEntity(List<AppInfoEvnAddEntity> appInfoEnvAddEntity) {
		this.appInfoEnvAddEntity = appInfoEnvAddEntity;
	}
	


	

	
}
