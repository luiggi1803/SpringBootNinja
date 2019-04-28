package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/example2")
public class Example2Controller {

	private static final String EXAMPLE2_VIEW = "example2";
	
	//http://localhost:8080/example2/request1?nm=Luiggi
	//http://localhost:8080/example2/request1?nm=Eder
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name ="nm",required=false,defaultValue="NULL") String name) {
		ModelAndView model= new ModelAndView(EXAMPLE2_VIEW);
		model.addObject("nm_input_model",name);
		return model;
	}
	
	//http://localhost:8080/example2/request2/Luiggi
	//http://localhost:8080/example2/request2/Eder
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable(name="nm") String name) {
		ModelAndView model= new ModelAndView(EXAMPLE2_VIEW);
		model.addObject("nm_input_model",name);
		return model;
		
	}
	
	
}
