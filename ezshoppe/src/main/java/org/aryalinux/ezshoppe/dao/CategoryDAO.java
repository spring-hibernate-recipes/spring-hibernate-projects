package org.aryalinux.ezshoppe.dao;

import java.util.List;

import org.aryalinux.ezshoppe.model.ProductCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CategoryDAO extends GenericDAO<ProductCategory, Integer> {
	public CategoryDAO() {
		super(ProductCategory.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProductCategory> getTopLevelCategories() {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from ProductCategory where topLevel = :val");
		query.setParameter("val", new Integer(1));
		return (List<ProductCategory>) query.list();
	}
}
