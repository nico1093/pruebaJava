package com.capgemini.projectFinal.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="ALUMNOS")
public class Alumno {
	/*
	 * Modelar a un alumno
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ALUMNO")
	private int id_Alumno;
	@Column(name="NOMBRE")
	@NotNull
	private String nombre;
	@Column(name="APELLIDO")
	@NotNull
	private String apellido;
	@Column(name="ID_CURSO")
	private String id_Curso;
	@Column(name="DNI")
	@NotNull
	private Long dni;
	@Column(name="MAIL")
	@Email
	@NotNull
	private String mail;
	@Column(name="TELEFONO")
	private Long telefono;
	
	public Alumno() { }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getId_Curso() {
		return id_Curso;
	}

	public void setId_Curso(String id_Curso) {
		this.id_Curso = id_Curso;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public int getId_Alumno() {
		return id_Alumno;
	}

	@Override
	public String toString() {
		return "Alumno [id_Alumno=" + id_Alumno + ", nombre=" + nombre + ", apellido=" + apellido + ", id_Curso="
				+ id_Curso + ", dni=" + dni + ", mail=" + mail + ", telefono=" + telefono
				+ "]";
	}
	
	

}
