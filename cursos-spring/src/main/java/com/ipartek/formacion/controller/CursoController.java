package com.ipartek.formacion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.service.CursoService;

@Controller
@RequestMapping(value="/cursos")
public class CursoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);
	@Autowired
	private CursoService cS;
	private ModelAndView mav;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getAll(){
		mav=new ModelAndView("cursos");
		String mensaje="";
		mav.addObject("mensaje", mensaje);
		try{
			List<Curso> cursos=cS.getAll();
			mav.addObject("listadoCursos", cursos);
			if(cursos.size()==0){
				mensaje="En breve mostraremos un listado de cursos.";
			}
			return mav;
		}catch(Exception e){
			LOGGER.info(e.getMessage());
			mensaje="Se ha producido un error en la obtención del listado de cursos.";
			return mav;
		}
		
	}
	@RequestMapping(value="/addCurso")
	public String addCurso(Model model){
		model.addAttribute("curso", new Curso());
		return "curso";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("curso") Curso curso,Model model){
		String respuesta="";
		LOGGER.info(curso.toString());
		respuesta="redirect:/cursos";
			if(curso.getId()>curso.ID_NULO){
				try{
					cS.update(curso);
				}catch(Exception e){
					LOGGER.info(e.getMessage());
				}
			}else{
				try{
					cS.create(curso);
				}catch(Exception e){
					LOGGER.info(e.getMessage());
				}
			}
		return respuesta;
	}
	@RequestMapping(value="/{id}")
	public String getById(@PathVariable("id") Long id,Model model){
		String respuesta="curso";
		try{
			Curso curso=cS.getById(id);
			model.addAttribute("curso", curso);
			respuesta="curso";
			
		}catch(Exception e){
			LOGGER.info(e.getMessage());

		}
		
		return respuesta;

	}
	
	@RequestMapping(value="/deleteCurso/{id}")
	public String deleteCurso(@PathVariable("id") Long id,Model model){
		String respuesta="";
		try{
			cS.delete(id);
			respuesta="redirect:/cursos";
			return respuesta;
		}catch(Exception e){
			model.addAttribute("error", "Se ha producido un error y los cambios no han podido realizarse.");
			LOGGER.info(e.getMessage());
			respuesta="cursos";
			return respuesta;
		}
		
	}
	

}
