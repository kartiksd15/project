package com.xworkz.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dto.AppInfoDTO;
import com.xworkz.spring.entity.AppInfoEntity;
import com.xworkz.spring.entity.AppInfoEvnAddEntity;
import com.xworkz.spring.repository.RepositoryAppInfo;

@Service
public class AppInfoServiceImpl implements AppInfoService{
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AppInfoServiceImpl.class);
	
	@Autowired
	private  RepositoryAppInfo appInfo;
	
	public AppInfoServiceImpl() {
		LOGGER.info("created AppInfoServiceImpl"+this.getClass().getSimpleName());
	}

	@Override
	public AppInfoDTO create(AppInfoDTO dto, List<AppInfoDTO> list) {
		
		try {
				if(Objects.nonNull(dto) && Objects.nonNull(list)) {
					LOGGER.info("AppInfoDTO value doesn't null n doesn't save  in DB ..");
					
					AppInfoEntity appInfoEntity=new AppInfoEntity();
					List<AppInfoEvnAddEntity>	appInfoEvnAddEntiyList = new ArrayList<>();
					
					BeanUtils.copyProperties(dto, appInfoEntity);
					
					for(AppInfoDTO dtolist :list) { 
						
						AppInfoEvnAddEntity appInfoEvnAddEntity=new AppInfoEvnAddEntity();
						BeanUtils.copyProperties(dtolist,appInfoEvnAddEntity);
						
						appInfoEvnAddEntity.setAppInfoEntity(appInfoEntity);
						
						appInfoEvnAddEntiyList.add(appInfoEvnAddEntity);
						
					}
					
					appInfoEntity.setAppInfoEnvAddEntity(appInfoEvnAddEntiyList);
					
					appInfo.save(appInfoEntity);
				}else {
					LOGGER.info("appinfodto is does not save null value.. ");
				}
			
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			
		}

		return null;
	}
	
	
	

}
