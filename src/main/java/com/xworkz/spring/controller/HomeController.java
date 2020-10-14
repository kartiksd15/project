package com.xworkz.spring.controller;

 
import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.spring.dto.AppInfoDTO;
import com.xworkz.spring.dto.EnvDTO;
import com.xworkz.spring.dto.HomeDTO;
import com.xworkz.spring.entity.AppInfoEntity;
import com.xworkz.spring.service.AppInfoService;
import com.xworkz.spring.service.ServiceMessage;


@Controller
@RequestMapping("/")
public class HomeController {
	
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ServiceMessage serviceMessage;
	
	@Autowired
	private AppInfoService appInfoService;
	
	private List<EnvDTO> envlist =new ArrayList<EnvDTO>();

	public HomeController() {
		log.info(" Created..."+this.getClass().getSimpleName() );
	}
	

	@RequestMapping("index")
	public String onLanding() {
		log.info("Hello welcome to Home Page... ");
		return "index";
	}
	
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, (PropertyEditor) new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	

//	@RequestMapping("event")
//	public String onLandSuccess(HomeDTO homeDTO, Model model) {
//		LOGGER.info("Inside onLandSuccess()... ");
//		LOGGER.info("Name is: " + homeDTO.getName() + "\t Message is: " + homeDTO.getMessage());
//		model.addAttribute("name1", homeDTO.getName());
//		model.addAttribute("message1", homeDTO.getMessage());
//		return "Success";
//	}
	

//	 ModelAndView merely holds both to make it possible for a controller to return both model and 
//	view in a single return value. 
//	The view is resolved by a ViewResolver object; the model is data stored in a Map 
	
	
//	Add all attributes contained in the provided Map to the model.
//	Add an attribute to the model using parameter name generation. 
//	Add an attribute to the model.
//	Clear the state of this ModelAndView object.
	
	
//	@RequestMapping("event")
//	public String onAdd(@RequestParam String name,@RequestParam String message,Model model) {
//		LOGGER.info("Add msg controller..");
//		LOGGER.info("Name"+name+"msg"+message);
//		MessageEntity msgentity=new MessageEntity();
//		msgentity.setMessage(message);
//		msgentity.setName(name);
//		serviceMessage.save(msgentity);
//		LOGGER.info("data saved in dataBase");
//		model.addAttribute("id", msgentity.getId());
//		model.addAttribute("message1", msgentity.getMessage());
//		model.addAttribute("name1", msgentity.getName());
//		return "Success";
//		
//	}
	
	@RequestMapping("event")
	public ModelAndView addMessage(HomeDTO homeDto, Model model) {
		log.info("invoking addMessage() of " + this.getClass().getSimpleName());
		ModelAndView modelAndView = new ModelAndView();
		try {
			boolean check = this.serviceMessage.validAndSave(homeDto, model);
			if (check == true) {
				log.info("Check is " + check);
				log.info("Data Saved in DataBaseTable");
				modelAndView.addObject("object", homeDto);
				modelAndView.setViewName("home");
				return modelAndView;
			} else {
				log.error("Data is not Saved in DB");
				modelAndView.setViewName("index");
				return modelAndView;
			}
		} catch (Exception e) {
			log.error("Exception in Controller" + e.getMessage());
		}
		return modelAndView;
	}
	
	
	
/*	
	@RequestMapping(value = "/sendApp", method = RequestMethod.POST)
	public String getModalData(AppInfoDTO appInfoDTO, Model model) {

		list.add(appInfoDTO);
		System.out.println(list);
		model.addAttribute("appList", list);

		return "login";

	}*/

	
	//module-1
	
//	@RequestMapping(value = "/sendlogin", method = RequestMethod.POST)
//	public String addAppInfoDetails(AppInfoDTO appInfoDTO, Model model) {
//		log.info("invoked addAppInfoDetails method");
//		appInfoService.create(appInfoDTO, list);
//		return "Login";
//	}
	
//	@RequestMapping(value = "/sendlogin", method = RequestMethod.POST)
	
	@PostMapping("/login")
	public String addApp(AppInfoDTO appInfoDTO,Model model) {
		try {
		log.info("adding application ");
		String check=null;
		log.info("dto is"+appInfoDTO);
		check= appInfoService.save(appInfoDTO,envlist);
		envlist.removeAll(envlist);
		System.out.println("list is:"+envlist);
		log.info("status is "+check);
		model.addAttribute("status", check);
		
		
	}catch(Exception e) {
		log.error("error is appinfopage"+this.getClass().getSimpleName());
	}
		
		return "Login";
		
	}
	
	
//	@RequestMapping(value = "sendApp", method = RequestMethod.POST)
	@PostMapping("addEnv")
	public ResponseEntity<Object> getModalData(@RequestBody EnvDTO envDTO){
		
		log.info("invoked"+this.getClass().getSimpleName());
		log.info("env name:"+envDTO.getEnv());
		log.info("url name:"+envDTO.getUrl());
		envlist.add(envDTO);
//		envlist=list;
		envlist.forEach(p->System.out.print(p));
		
		return ResponseEntity.ok().body("Success");
		
	}
	
	
	
//	@RequestMapping(value = "sendApp", method = RequestMethod.POST)
//	public ResponseEntity<Object> getModalData(@RequestBody AppInfoDTO appInfoDTO) {
//		 
//		list.add(appInfoDTO);
//
//		System.out.println(list);
//		
//		return ResponseEntity.ok().body("Success");
//
//	}
	
	
	
	
	@RequestMapping(value="/login")
	public String call() {
		return "Login";
	}
	
}
