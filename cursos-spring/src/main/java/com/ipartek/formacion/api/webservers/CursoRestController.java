package com.ipartek.formacion.api.webservers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.service.CursoService;


@RestController
@RequestMapping(value="/api/cursos")
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET})
public class CursoRestController {
	private final static Logger LOGGER=LoggerFactory.getLogger(CursoRestController.class);
	@Autowired
	private CursoService cS;
	
	@RequestMapping(method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Curso>> buscador(@RequestParam("paramBusq") String busq){
		ResponseEntity<List<Curso>> respuesta=null;
		LOGGER.info(busq);
		try{
			List<Curso> cursos=cS.getByNombre(busq.toUpperCase());
			
			if(cursos==null||cursos.isEmpty()||cursos.size()==0){
				respuesta=new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
			} else{
				LOGGER.info(String.valueOf(cursos.size()));
				respuesta=new ResponseEntity<List<Curso>>(cursos,HttpStatus.OK);
			}
			}catch(Exception e){
				LOGGER.info(e.getMessage());
			}
		
		return respuesta;
		
	}
	

}
