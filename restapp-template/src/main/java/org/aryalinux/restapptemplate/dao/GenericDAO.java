package org.aryalinux.restapptemplate.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public F create(E ref) {
		return (F) sessionFactory.getCurrentSession().save(ref);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public E getById(F id) {
		return (E) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> getAll() {
		return (List<E>) sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> getByParams(Map<String, Object> params) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		for (Entry<String, Object> entry : params.entrySet()) {
			if (entry.getValue() == null) {
				criteria.add(Restrictions.isNull(entry.getKey()));
			} else {
				criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
			}
		}
		return (List<E>) criteria.list();
	}

	@Transactional
	public void update(E ref) {
		sessionFactory.getCurrentSession().update(ref);
	}

	@Transactional
	public void delete(E ref) {
		sessionFactory.getCurrentSession().delete(ref);
	}
}
