package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Autor;

public interface AutorDAO {

	//CRUD Basico
	
		public List<Autor> findALL();
		
		public Autor findOne(int id);
		
		public void add(Autor autor);
		
		public void up(Autor autor);
		
		public void del(int id);

	
	
}
