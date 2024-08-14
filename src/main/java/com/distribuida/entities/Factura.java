package com.distribuida.entities;

import java.util.Date;

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
@Table(name = "factura")

public class Factura {
	
	//@OneToOne
	//@ManyToOne
	//@OneToMany
	
	

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private int idFactura;
	@Column(name ="num_factura")
	private String num_factura;
	@Column(name ="fecha")
	private Date fecha;
	@Column(name ="total_neto")
	private double total_neto;
	@Column(name = "iva")
	private double iva;
	@Column(name ="total")
	private double total;
	
	
	//private int idCliente;
	@JoinColumn(name ="id_cliente") 
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	
	private Cliente cliente;
	
	
	




	public Factura(int idFactura, String num_factura, Date fecha, double total_neto, double iva, double total) {
			 
		this.idFactura = idFactura;
		this.num_factura = num_factura;
		this.fecha = fecha;
		this.total_neto = total_neto;
		this.iva = iva;
		this.total = total;
		
	}



	public int getIdFactura() {
		return idFactura;
	}



	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}



	public String getNum_factura() {
		return num_factura;
	}



	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public double getTotal_neto() {
		return total_neto;
	}



	public void setTotal_neto(double total_neto) {
		this.total_neto = total_neto;
	}



	public double getIva() {
		return iva;
	}



	public void setIva(double iva) {
		this.iva = iva;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", num_factura=" + num_factura + ", fecha=" + fecha + ", total_neto="
				+ total_neto + ", iva=" + iva + ", total=" + total + ", cliente=" + cliente + "]";
	}


}
	