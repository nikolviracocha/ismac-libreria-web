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
public class categoria {
	
	// Atributos
			@Id
			@GeneratedValue(strategy =  GenerationType.IDENTITY)
			@Column(name="id_categoria")
			private String idcategoria;
			@Column(name="categoria")
			private String categoria;
			
		// Constructor 
			public categoria() {}
			
			public categoria(String idcategoria, String categoria) {
				super();
				this.idcategoria = idcategoria;
				this.categoria = categoria;
			}
			public String getIdcategoria() {
				return idcategoria;
			}
			public void setIdcategoria(String idcategoria) {
				this.idcategoria = idcategoria;
			}
			public String getCategoria() {
				return categoria;
			}
			public void setCategoria(String categoria) {
				this.categoria = categoria;
			}
			@Override
			public String toString() {
				return "categoria [idcategoria=" + idcategoria + ", categoria=" + categoria + "]";
			}
	}
