package com.xworkz.spring.service;

import org.springframework.ui.Model;

import com.xworkz.spring.dto.HomeDTO;

public interface ServiceMessage {

	
	
	public boolean validAndSave(HomeDTO homeDTO,Model model);

//	
//	@Autowired
//	private RepositoryMessage repositoryMessage;
//	
//	public ServiceMessage() {
//		LOGGER.info(this.getClass().getSimpleName()+"created");
//	}
//	
//	public void save(MessageEntity messageEntity) {
//		LOGGER.info(this.getClass().getSimpleName()+"created");
//		repositoryMessage.save(messageEntity);
//	}

}
