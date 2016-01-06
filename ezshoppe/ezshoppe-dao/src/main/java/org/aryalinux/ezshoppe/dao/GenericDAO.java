package org.aryalinux.ezshoppe.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Transactional
	@SuppressWarnings("unchecked")
	public F create(E ref) {
		Session session = sessionFactory.getCurrentSession();
		return (F) session.save(ref);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public E getById(F id) {
		Session session = sessionFactory.getCurrentSession();
		return (E) session.get(clazz, id);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<E> getByCriteria(Map<String, Object> criteria) {
		List<E> results = new ArrayList<E>();
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria2 = session.createCriteria(clazz);
		for (Entry<String, Object> entry : criteria.entrySet()) {
			if (entry.getValue() == null) {
				criteria2.add(Restrictions.isNull(entry.getKey()));
			}
			else {
				criteria2.add(Restrictions.eq(entry.getKey(), entry.getValue()));
			}
		}
		results = (List<E>) criteria2.list();
		return results;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		List<E> results = new ArrayList<E>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from " + clazz);
		results = (List<E>) query.list();
		return results;
	}

	@Transactional
	public void update(E ref) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ref);
	}

	@Transactional
	public void delete(E ref) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(ref);
	}
}
