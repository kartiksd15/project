package com.xworkz.spring.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name="ENIRONMENT_TABLE")
public class AppInfoEvnAddEntity implements Serializable{
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppInfoEvnAddEntity.class);
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "Env_ID")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	@Column(name = "ENV_name")
	private String env;
	@Column(name = "URL")
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "Proj_Id")
	private AppInfoEntity appInfoEntity;

	public AppInfoEvnAddEntity() {
		log.info("created AppInfoEvnAddEntity."+this.getClass().getSimpleName());
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
