package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Categoria;

@Repository

public class CategoriaDAOImpl implements CategoriaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public List<Categoria> findALL() {
		//TODO Auto-generated method stub
				Session session=sessionFactory.getCurrentSession();
				
				return session.createQuery("from Categoria",Categoria.class).getResultList();
	}

	
	
	
	@Override
	@Transactional
	public Categoria findOne(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return  session.get(Categoria.class,id);
	}

	@Override
	@Transactional
	public void add(Categoria Categoria) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(Categoria);

	}

	@Override
	@Transactional
	public void up(Categoria Categoria) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(Categoria);

	}

	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));
	}

}