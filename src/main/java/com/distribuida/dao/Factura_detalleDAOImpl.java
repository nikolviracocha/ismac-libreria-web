package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Factura_detalle;

@Repository

public class Factura_detalleDAOImpl implements Factura_detalleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public List<Factura_detalle> findAll() {
		//TODO Auto-generated method stub
				Session session=sessionFactory.getCurrentSession();
				
				return session.createQuery("from Factura_detalle",Factura_detalle.class).getResultList();
	}

	
	
	
	@Override
	@Transactional
	public Factura_detalle findOne(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return  session.get(Factura_detalle.class,id);
	}

	@Override
	@Transactional
	public void add(Factura_detalle Factura_detalle) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(Factura_detalle);

	}

	@Override
	@Transactional
	public void up(Factura_detalle Factura_detalle) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(Factura_detalle);

	}

	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));
	}

}