package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Factura_detalle;

public interface Factura_detalleDAO {
	
	//CRUD Basico
	
	public List<Factura_detalle> findAll();
	
	public Factura_detalle findOne(int id);
	
	public void add(Factura_detalle FacturaDetalle);
	
	public void up(Factura_detalle FacturaDetalle);
	
	public void del(int id);
	
	//CRUD Avanzado
	
	
	
	
	
	
	

}
