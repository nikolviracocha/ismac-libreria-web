package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<categoria> findALL(){
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from categoria",categoria.class).getResultList();
	
	}

	@Override
	public categoria findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void up(categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		
	}

	

	
		
}