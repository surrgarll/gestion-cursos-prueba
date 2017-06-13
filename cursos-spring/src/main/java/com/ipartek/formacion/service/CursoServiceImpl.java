package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.persistence.Curso;
import com.ipartek.formacion.persistence.CursoDAO;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoDAO cDao;
	
	@Override
	public void setCursoDAO(CursoDAO cursoDao) {
		this.cDao=cursoDao;
		
	}

	@Override
	public List<Curso> getAll() {
		return cDao.getAll();
	}

	@Override
	public Curso getById(Long id) {
		
		return cDao.getById(id);
	}

	@Override
	public Curso create(Curso curso) {
		return cDao.create(curso);
	}

	@Override
	public Curso update(Curso curso) {
		
		return cDao.update(curso);
	}

	@Override
	public void delete(Long id) {
		cDao.delete(id);

	}

	@Override
	public List<Curso> getByNombre(String nombre) {
		
		return null;
	}


}
