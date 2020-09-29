package com.xworkz.spring.controller;

 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.spring.entity.MessageEntity;
import com.xworkz.spring.service.ServiceMessage;


@Controller
public class HomeController {
	
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ServiceMessage serviceMessage;

	public HomeController() {
		LOGGER.info(this.getClass().getSimpleName() + " Created...");
	}
	

	@RequestMapping("index")
	public String onLanding() {
		LOGGER.info("Hello welcome to Home Page... ");
		return "index";
	}

//	@RequestMapping("event")
//	public String onLandSuccess(HomeDTO homeDTO, Model model) {
//		LOGGER.info("Inside onLandSuccess()... ");
//		LOGGER.info("Name is: " + homeDTO.getName() + "\t Message is: " + homeDTO.getMessage());
//		model.addAttribute("name1", homeDTO.getName());
//		model.addAttribute("message1", homeDTO.getMessage());
//		return "Success";
//	}
	
	@RequestMapping("event")
	public String onAdd(@RequestParam String name,@RequestParam String message,Model model) {
		LOGGER.info("Add msg controller..");
		LOGGER.info("Name"+name+"msg"+message);
		MessageEntity msgentity=new MessageEntity();
		msgentity.setMessage(message);
		msgentity.setName(name);
		serviceMessage.save(msgentity);
		LOGGER.info("data saved in dataBase");
		model.addAttribute("id", msgentity.getId());
		model.addAttribute("message1", msgentity.getMessage());
		model.addAttribute("name1", msgentity.getName());
		return "Success";
		
	}
}
