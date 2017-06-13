package com.ipartek.formacion.persistence;

import java.util.List;

public interface CursoDAO extends DAOSetter {
	public List<Curso> getAll();
	public Curso getById(Long id);
	public Curso create(Curso curso);
	public Curso update(Curso curso);
	public void delete(Long id);
	public List<Curso> getByNombre(String nombre);

}
