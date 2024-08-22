package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Autor;

@Repository

public class AutorDAOImpl implements AutorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public List<Autor> findALL() {
		//TODO Auto-generated method stub
				Session session=sessionFactory.getCurrentSession();
				
				return session.createQuery("from Autor",Autor.class).getResultList();
	}

	
	
	
	@Override
	@Transactional
	public Autor findOne(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return  session.get(Autor.class,id);
	}

	@Override
	@Transactional
	public void add(Autor Autor) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(Autor);

	}

	@Override
	@Transactional
	public void up(Autor Autor) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(Autor);

	}

	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));
	}

}