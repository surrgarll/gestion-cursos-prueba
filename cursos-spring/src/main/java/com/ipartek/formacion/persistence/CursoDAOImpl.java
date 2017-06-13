package com.ipartek.formacion.persistence;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.persistence.mapper.CursoMapper;

@Repository("cursoDaoImpl")
public class CursoDAOImpl implements CursoDAO {
	
	private final static Logger LOGGER=LoggerFactory.getLogger(CursoDAOImpl.class);
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbctemplate=new JdbcTemplate(dataSource);
		
	}
	
	@Override
	public List<Curso> getAll() {
		List<Curso> cursos=null;
		final String SQL="call cursoReadAll();";
		cursos=jdbctemplate.query(SQL, new CursoMapper());	
		return cursos;
	}

	@Override
	public Curso getById(Long id) {
		Curso curso=null;
		final String SQL="call cursoReadById(?);";
		curso=jdbctemplate.queryForObject(SQL, new CursoMapper(), new Object[]{id});
		return curso;
	}

	@Override
	public Curso create(Curso curso) {
		final String SQL="cursoCreate";
		this.jdbcCall=new SimpleJdbcCall(jdbctemplate);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in=new MapSqlParameterSource() 
				.addValue("pnombre", curso.getNombre())
				.addValue("pcodigo", curso.getCodigo());
		Map<String,Object> out=null;	
		out=jdbcCall.execute(in);
		curso.setId((Long)out.get("id"));
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		final String SQL="cursoUpdate";
		this.jdbcCall=new SimpleJdbcCall(jdbctemplate);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in=new MapSqlParameterSource()
				.addValue("pid", curso.getId())
				.addValue("pnombre", curso.getNombre())
				.addValue("pcodigo", curso.getCodigo());
		jdbcCall.execute(in);	
		return curso;
	}

	@Override
	public void delete(Long id) {
		final String SQL="cursoDelete";
		this.jdbcCall=new SimpleJdbcCall(jdbctemplate);
		jdbcCall.withProcedureName(SQL);
		SqlParameterSource in=new MapSqlParameterSource().addValue("pid", id);
		jdbcCall.execute(in);

	}

	@Override
	public List<Curso> getByNombre(String nombre) {
		List<Curso> cursos=null;
		final String SQL="call cursoReadByName(?);";
		cursos=jdbctemplate.query(SQL, new Object[]{nombre}, new CursoMapper());	
		return cursos;
	}

}
