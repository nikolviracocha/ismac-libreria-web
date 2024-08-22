package com.distribuida.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name ="Categoria")
public class Categoria {
	
	// Atributos
			@Id
			@GeneratedValue(strategy =  GenerationType.IDENTITY)
			@Column(name="id_categoria")
			private int idCategoria;
			@Column(name="categoria")
			private String categoria;
			
		// Constructor 
			public Categoria() {}
			
			public Categoria(int idcategoria, String categoria) {
				
				this.idCategoria = idcategoria;
				this.categoria = categoria;
			}
			public int getIdCategoria() {
				return idCategoria;
			}
			public void setIdCategoria(int idcategoria) {
				this.idCategoria = idcategoria;
			}
			public String getCategoria() {
				return categoria;
			}
			public void setCategoria(String categoria) {
				this.categoria = categoria;
			}
			@Override
			public String toString() {
				return "Categoria [idCategoria=" + idCategoria + ", categoria=" + categoria + "]";
			}
	}
