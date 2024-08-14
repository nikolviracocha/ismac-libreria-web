package com.distribuida.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "factura_detalle")

public class Factura_detalle {
	
	
	//@OneToOne
		//@ManyToOne
		//@OneToMany
		
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Factura_detalle")
	private int idFactura_detalle;
	@Column(name ="cantidad")
	private int cantidad;
	@Column(name ="subtotal")
	private double subtotal;
	
	
	
	//private int idCliente;
	@JoinColumn(name ="id_factura") 
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Factura factura;
	
	@JoinColumn(name ="id_libro") 
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Libro libro;
	


		
	public Factura_detalle(int idFactura_detalle, int cantidad, double subtotal, Factura factura,
			com.distribuida.entities.Libro libro) {
		
		this.idFactura_detalle = idFactura_detalle;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.factura = factura;
        this.libro = libro;
	
	}





	public int getIdFactura_detalle() {
		return idFactura_detalle;
	}





	public void setIdFactura_detalle(int idFactura_detalle) {
		this.idFactura_detalle = idFactura_detalle;
	}





	public int getCantidad() {
		return cantidad;
	}





	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}





	public double getSubtotal() {
		return subtotal;
	}





	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}





	public Factura getFactura() {
		return factura;
	}





	public void setFactura(Factura factura) {
		this.factura = factura;
	}





	public Libro getLibro() {
		return libro;
	}





	public void setLibro(Libro libro) {
		this.libro = libro;
	}





	@Override
	public String toString() {
		return "Factura_detalle [idFactura_detalle=" + idFactura_detalle + ", cantidad=" + cantidad + ", subtotal="
				+ subtotal + ", factura=" + factura + ", libro=" + libro + "]";
	}


}
