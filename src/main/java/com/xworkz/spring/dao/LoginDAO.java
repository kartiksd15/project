package com.xworkz.spring.dao;

import java.util.List;

import com.xworkz.spring.entity.AppInfoEntity;
import com.xworkz.spring.entity.AppInfoEvnAddEntity;

public interface LoginDAO {
	
	public String save(AppInfoEntity appInfoEntity,List<AppInfoEvnAddEntity> list);

}
