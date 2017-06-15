package com.ipartek.formacion.persistence;

import java.io.Serializable;

public class Curso implements Serializable,Comparable<Curso> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final long ID_NULO = -1;
	private Long id;
	private String nombre;
	private String codigo;
	
	
	
	public Curso() {
		super();
		this.id=ID_NULO;
		this.nombre="";
		this.codigo="000000000000";
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	@Override
	public int compareTo(Curso o) {
		int numero=this.getId().compareTo(o.getId());
		return numero;
	}

	
	
	

}
