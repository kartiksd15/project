package com.xworkz.spring.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.spring.dto.HomeDTO;
import com.xworkz.spring.entity.MessageEntity;
import com.xworkz.spring.repository.RepositoryMessage;

@Service
public class ServiceMessageImpl implements ServiceMessage{
	
	@Autowired
	private RepositoryMessage repositoryMessage;
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ServiceMessageImpl.class);
	
	
	public ServiceMessageImpl() {
	LOGGER.info("created ServiceMessageImpl"+this.getClass().getSimpleName());
	}

	@Override
	public boolean validAndSave(HomeDTO homeDTO, Model model) {
		LOGGER.info("validate the input data"+this.getClass().getSimpleName());
		
		boolean flag = false;
		try {
			
			String name = homeDTO.getName();
			if (name != null && !name.isEmpty() && name.length() <= 10 && name.charAt(0) != ' ') {
				LOGGER.info("Enter User Name is valid");
				flag = true;
			} else {
				LOGGER.error("Enter UserName is Not valid");
				model.addAttribute("name", "Enter name is invalid");
				flag = false;
				return flag;
			}

			String msg = homeDTO.getMessage();
			if (msg != null && !msg.isEmpty() && msg.length() <= 30) {
				LOGGER.info("Enter Message is valid");
				flag = true;
			} else {
				LOGGER.error("Enter Message is Not valid,Please enter valid Message");
				model.addAttribute("message", "Enter Message is invalid");
				flag = false;
				return flag;
			}
			
			

			if (flag == true) {
				MessageEntity messageEntity = new MessageEntity();
				messageEntity.setName(homeDTO.getName());
				messageEntity.setMessage(homeDTO.getMessage());
				messageEntity = repositoryMessage.save(messageEntity);
				LOGGER.info("All fields are valid ..");
				
				
				if (messageEntity.getId() != null) {
					homeDTO.setId(messageEntity.getId());
				}
			}
			
		} catch (Exception e) {
			LOGGER.error("Exception present in Controller " + e.getMessage());
		}
		
		return flag;
	}

}
