package com.capgemini.projectFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="CURSOS")

public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CURSO")
	private int idCursos;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_profesor")
	private Profesor profesor;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@NotNull
	private List<Tema> temas = new ArrayList<Tema>();
	
	public Curso() {}
	
	public Curso(String nombre) {
		this.nombre = nombre;
	}

	public int getIdCursos() {
		return idCursos;
	}

	public void setIdCursos(int idCursos) {
		this.idCursos = idCursos;
	}

	public String getNombre_Curso() {
		return nombre;
	}

	public void setNombre_Curso(String nombre_Curso) {
		this.nombre = nombre_Curso;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	//Agregar un tema al curso. El cual otro no puede tener
	public void addTemas(Tema tema) {
		temas.add(tema);//Agrega un tema 
		tema.setCurso(this);//Al tema le asigna el curso.
	}
	
	
	@Override
	public String toString() {
		return "Curso [idCursos=" + idCursos + ", nombre_Curso=" + nombre + ", profesor=" + profesor + ", temas="
				+ temas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCursos;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (idCursos != other.idCursos)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
