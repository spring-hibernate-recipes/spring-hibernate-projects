package org.aryalinux.shopper.data.dao.impl;

import java.util.List;

import org.aryalinux.shopper.data.dao.CategoryDAO;
import org.aryalinux.shopper.data.model.ProductCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Integer create(ProductCategory category) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(category);
	}

	@Transactional
	public void delete(ProductCategory category) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(category);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProductCategory> listAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ProductCategory");
		return (List<ProductCategory>) query.list();
	}

	@Transactional
	public ProductCategory getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ProductCategory where id=:id");
		query.setParameter("id", id);
		return (ProductCategory) query.list();
	}

	@Transactional
	public void update(ProductCategory category) {
		Session session = sessionFactory.getCurrentSession();
		session.update(category);
	}

}
