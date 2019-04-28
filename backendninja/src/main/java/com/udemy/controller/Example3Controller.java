package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	public static final String FORM_VIEW="form";
	public static final String RESULT_VIEW="result";
	public static final Log LOGGER=LogFactory.getLog(Example3Controller.class);
	
	//#1
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example3/showform";
//		
//	}
	
	//#2
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	
	
	@GetMapping("/showform")
	public String showform(Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute(name="person") Person person, BindingResult bindingResult) {
		LOGGER.info("METHOD: 'addPerson' -- Param: '" + person +"'");
		ModelAndView model= new ModelAndView();
		if(bindingResult.hasErrors()) {
			model.setViewName(FORM_VIEW);
		}else {
			model.setViewName(RESULT_VIEW);
			model.addObject("person", person);
		}

		return model;
		
	}
	
}
