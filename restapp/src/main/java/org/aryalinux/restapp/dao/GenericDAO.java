package org.aryalinux.restapp.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.aryalinux.restapp.common.EntityList;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("rawtypes")
@Component
public class GenericDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Serializable create(Object ref) {
		return (Serializable) sessionFactory.getCurrentSession().save(ref);
	}

	@Transactional
	public Object getById(Class clazz, Serializable id) {
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Transactional
	public List getAll(Class clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}

	@Transactional
	public List getByParams(Class clazz, Map<String, Object> params) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
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

	/*
	 * TODO: repair. Hibernate needs to know the class name
	 * of the entity so that it can perform appropriate action
	 * on the corresponding table
	 */
	@Transactional
	public Serializable execute(EntityList entityList) {
		Serializable id = null;
		for (int i = 0; i < entityList.getEntities().size(); i++) {
			Object entity = entityList.getEntities().get(i);
			int operation = entityList.getOperations().get(i);
			if (entityList.getPrimaryEntityIndex() == i) {
				id = sessionFactory.getCurrentSession().save(entity);
			} else {
				switch (operation) {
				case 1:
					sessionFactory.getCurrentSession().save(entity);
					break;
				case 2:
					sessionFactory.getCurrentSession().update(entity);
					break;
				case 3:
					sessionFactory.getCurrentSession().delete(entity);
					break;
				default:
					break;
				}
			}
		}
		return id;
	}
}
