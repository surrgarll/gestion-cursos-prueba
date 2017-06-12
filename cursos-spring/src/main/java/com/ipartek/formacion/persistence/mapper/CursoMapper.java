package com.ipartek.formacion.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.persistence.Curso;

public class CursoMapper implements RowMapper<Curso> {

	@Override
	public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Curso curso=new Curso();
		curso.setId(rs.getLong("id"));
		curso.setCodigo(rs.getString("codigo"));
		curso.setNombre(rs.getString("nombre"));	
		return curso;
	}
	

}
