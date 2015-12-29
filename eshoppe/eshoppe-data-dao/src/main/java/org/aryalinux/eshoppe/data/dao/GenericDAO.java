package org.aryalinux.eshoppe.data.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class GenericDAO<E, F extends Serializable> {
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("rawtypes")
	private Class clazz;

	@SuppressWarnings("rawtypes")
	public GenericDAO(Class clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public F create(E ref) {
		Session session = sessionFactory.getCurrentSession();
		return (F) session.save(ref);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public E findById(F id) {
		Session session = sessionFactory.getCurrentSession();
		return (E) session.get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<E> findByCriteria(Map<String, Object> criteria) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria2 = session.createCriteria(clazz);
		for (Entry<String, Object> entry : criteria.entrySet()) {
			criteria2.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}
		return criteria2.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		return criteria.list();
	}

	public void update(E ref) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ref);
	}

	public void delete(E ref) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(ref);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
