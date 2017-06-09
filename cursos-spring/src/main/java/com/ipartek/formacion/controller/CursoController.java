package com.ipartek.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.service.CursoService;

@Controller
@RequestMapping(value="/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cS;
	private ModelAndView mav;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("cursos");
 		List<Curso> cursos=cS.getAll();
 		mav.addObject("listadoCursos", cursos);
 		return mav;
		
	}
	@RequestMapping(value="/addCurso")
	public String addCurso(Model model){
		model.addAttribute("curso", new Curso());
		return "curso";
	}
	

}
