package com.xworkz.spring.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.LoggerFactory;

@Entity
@Table(name="Env_Table")
public class AppInfoEvnAddEntity {
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AppInfoEvnAddEntity.class);
	@Id
	@Column(name = "E_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	@Column(name = "ENV")
	private String env;
	@Column(name = "URL")
	private String url;
	@ManyToOne
	@JoinColumn(name = "ENV_ID")
	private AppInfoEntity appInfoEntity;

	public AppInfoEvnAddEntity() {
		LOGGER.info("created AppInfoEvnAddEntity."+this.getClass().getSimpleName());
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	public AppInfoEntity getAppInfoEntity() {
		return appInfoEntity;
	}

	public void setAppInfoEntity(AppInfoEntity appInfoEntity) {
		this.appInfoEntity = appInfoEntity;
	}
	
	
	
	
}
