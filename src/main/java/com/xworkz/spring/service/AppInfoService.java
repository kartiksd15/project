package com.xworkz.spring.service;

import java.util.List;

import com.xworkz.spring.dto.AppInfoDTO;

public interface AppInfoService {
	
	public AppInfoDTO create(AppInfoDTO dto,List<AppInfoDTO> list);
	

}
