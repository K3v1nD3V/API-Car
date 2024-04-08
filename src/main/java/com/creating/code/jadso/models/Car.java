package com.creating.code.jadso.models;
import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="cars")
public class Car implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank 
	@Column(name = "marca")
	private String marca;
	
	@NotBlank 
	@Column(name = "modelo")
	private String modelo;
	
	@NotBlank 
	@Column(name = "precio")
	private String precio;
	
	@Column(name = "ano")
	private String ano;
	
	@Column(name = "color") 
	private String color;
	
	@Column(name = "matricula") 
	private String matricula;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	} 

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	} 

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	} 
}
