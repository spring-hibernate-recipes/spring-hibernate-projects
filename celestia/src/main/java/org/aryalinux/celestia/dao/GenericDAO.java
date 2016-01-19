package org.aryalinux.celestia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class GenericDAO<E, F extends Serializable> {
	@Autowired
	private SessionFactory sessionFactory;
	private Class clazz;

	public GenericDAO(Class clazz) {
		this.clazz = clazz;
	}

	@Transactional
	public F save(E ref) {
		Session session = sessionFactory.getCurrentSession();
		return (F) session.save(ref);
	}

	@Transactional
	public List<E> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		return (List<E>) criteria.list();
	}

	@Transactional
	public E getById(F id) {
		Session session = sessionFactory.getCurrentSession();
		return (E) session.get(clazz, id);
	}

	@Transactional
	public List<E> getByParams(Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		for (Entry<String, Object> entry : params.entrySet()) {
			criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}
		return (List<E>) criteria.list();
	}

	@Transactional
	public void delete(E ref) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(ref);
	}

	@Transactional
	public void update(E ref) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ref);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
