package org.aryalinux.restapp.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("rawtypes")
public class GenericDAO {
	private SessionFactory sessionFactory;
	private Class entityClass;

	public GenericDAO(Class entityClass) {
		this.entityClass = entityClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}

	@Transactional
	public Object create(Object ref) {
		return (Serializable) sessionFactory.getCurrentSession().save(ref);
	}

	@Transactional
	public Object getById(Serializable id) {
		return (Serializable) sessionFactory.getCurrentSession().get(entityClass, id);
	}

	@Transactional
	public List getAll() {
		return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
	}

	@Transactional
	public List getByParams(Map<String, Object> params) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
		for (Entry<String, Object> entry : params.entrySet()) {
			if (entry.getValue() == null) {
				criteria.add(Restrictions.isNull(entry.getKey()));
			} else {
				criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
			}
		}
		return criteria.list();
	}

	@Transactional
	public void update(Object ref) {
		sessionFactory.getCurrentSession().update(ref);
	}

	@Transactional
	public void delete(Object ref) {
		sessionFactory.getCurrentSession().delete(ref);
	}
}
