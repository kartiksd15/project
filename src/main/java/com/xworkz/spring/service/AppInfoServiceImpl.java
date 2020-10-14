package com.xworkz.spring.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.spring.dao.LoginDAO;
import com.xworkz.spring.dto.AppInfoDTO;
import com.xworkz.spring.dto.EnvDTO;
import com.xworkz.spring.entity.AppInfoEntity;
import com.xworkz.spring.entity.AppInfoEvnAddEntity;
import com.xworkz.spring.repository.RepositoryAppInfo;



@Service
public class AppInfoServiceImpl implements AppInfoService{
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppInfoServiceImpl.class);
	
//	@Autowired
//	private  RepositoryAppInfo appInfo;
	
	@Autowired
	LoginDAO loginDAO;
	
	
	
	public AppInfoServiceImpl() {
		log.info("created AppInfoServiceImpl"+this.getClass().getSimpleName());
	}

	@Override
	public String save(AppInfoDTO appInfoDTO, List<EnvDTO> envDTOs) {
		log.info("invoked save method()");
		
		AppInfoEntity appInfoEntity=new AppInfoEntity();
		List<AppInfoEvnAddEntity> appInfoEvnAddEntityList=new ArrayList<>();
		
		String name=null;
		try {
			if(Objects.nonNull(appInfoDTO)) {
				log.info("appInfoDto is not empty");
				{
//
					ModelMapper mapper = new ModelMapper();
//					BeanUtils(appInfoDTO,appInfoEntity);
					mapper.map(appInfoDTO, appInfoEntity);
					 
					for(EnvDTO addEntity:envDTOs) {
						
					AppInfoEvnAddEntity appInfoEvnAddEntity=new AppInfoEvnAddEntity();
					mapper.map(addEntity, appInfoEvnAddEntity);
					
					appInfoEvnAddEntity.setAppInfoEntity(appInfoEntity);
					appInfoEvnAddEntityList.add(appInfoEvnAddEntity);
						
					}
					appInfoEntity.setAppInfoEnvAddEntity(appInfoEvnAddEntityList);
					log.info("AppInfoEnvAddEntity is"+appInfoEntity);
					
					name=loginDAO.save(appInfoEntity, appInfoEvnAddEntityList);
//					log.info("data print here:"+name);
					
				}
			}
			
		}catch(Exception e) {
			log.error("error present in save method."+this
					.getClass().getSimpleName());
		}
		
		
		return name;
	}

//	@Override
//	public AppInfoDTO create(AppInfoDTO dto, List<AppInfoDTO> list) {
//		
//		try {
//				if(Objects.nonNull(dto) && Objects.nonNull(list)) {
//					LOGGER.info("AppInfoDTO value doesn't null n doesn't save  in DB ..");
//					
//					AppInfoEntity appInfoEntity=new AppInfoEntity();
//					List<AppInfoEvnAddEntity>	appInfoEvnAddEntiyList = new ArrayList<>();
//					
//					BeanUtils.copyProperties(dto, appInfoEntity);
//					
//					for(AppInfoDTO dtolist :list) { 
//						
//						AppInfoEvnAddEntity appInfoEvnAddEntity=new AppInfoEvnAddEntity();
//						BeanUtils.copyProperties(dtolist,appInfoEvnAddEntity);
//						
//						appInfoEvnAddEntity.setAppInfoEntity(appInfoEntity);
//						
//						appInfoEvnAddEntiyList.add(appInfoEvnAddEntity);
//						
//					}
//					
//					appInfoEntity.setAppInfoEnvAddEntity(appInfoEvnAddEntiyList);
//					
//					appInfo.save(appInfoEntity);
//				}else {
//					LOGGER.info("appinfodto is does not save null value.. ");
//				}
//			
//		}catch(Exception e) {
//			LOGGER.error(e.getMessage());
//			
//		}
//
//		return null;
//	}
	
	
	

}
