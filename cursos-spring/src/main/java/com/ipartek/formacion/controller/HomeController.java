package com.ipartek.formacion.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.CursoService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CursoService cS;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(){
		
		return "home";
	}

}
