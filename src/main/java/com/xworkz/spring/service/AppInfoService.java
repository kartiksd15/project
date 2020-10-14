package com.xworkz.spring.service;

import java.util.List;

import com.xworkz.spring.dto.AppInfoDTO;
import com.xworkz.spring.dto.EnvDTO;

public interface AppInfoService {
	
//	public AppInfoDTO create(AppInfoDTO dto,List<AppInfoDTO> list);
	
	public String save(AppInfoDTO appInfoDTO,List<EnvDTO> envDTO);

}
