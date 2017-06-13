package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.persistence.CursoDAO;

public interface CursoService {
	public List<Curso> getAll();
	public Curso getById(Long id);
	public Curso create(Curso curso);
	public Curso update(Curso curso);
	public void delete(Long id);
	public void setCursoDAO(CursoDAO cursoDao);
	public List<Curso> getByNombre(String nombre);
	

}
