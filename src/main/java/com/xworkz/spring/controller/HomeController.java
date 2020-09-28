package com.xworkz.spring.controller;

 
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.spring.dto.HomeDTO;


@Controller
public class HomeController {
	
	
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	public HomeController() {
		System.out.println(this.getClass().getSimpleName() + " Created...");
	}
	

	@RequestMapping("index")
	public String onLanding() {
		LOGGER.info("Hello welcome to Home Page... ");
		return "index";
	}

	@RequestMapping("event")
	public String onLandSuccess(HomeDTO homeDTO, Model model) {
		LOGGER.info("Inside onLandSuccess()... ");
		LOGGER.info("Name is: " + homeDTO.getName() + "\t Message is: " + homeDTO.getMessage());
		model.addAttribute("name1", homeDTO.getName());
		model.addAttribute("message1", homeDTO.getMessage());
		return "Success";
	}
}
