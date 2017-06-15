package com.ipartek.formacion.controller;


import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.service.CursoService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CursoService cS;
	private ModelAndView mav;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView home(){	
		List<Curso> cursos=cS.getAll();
		mav=new ModelAndView("home");
		if(cursos!=null)
			Collections.reverse(cursos);
		mav.addObject("listadoCursos", cursos);
		return mav;
	}
	

}
