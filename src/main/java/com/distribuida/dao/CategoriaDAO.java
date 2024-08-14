package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.categoria;

public interface CategoriaDAO {

	//CRUD Basico
	
		public List<categoria> findALL();
		
		public categoria findOne(int id);
		
		public void add(categoria categoria);
		
		public void up(categoria categoria);
		
		public void del(int id);

		
		

}