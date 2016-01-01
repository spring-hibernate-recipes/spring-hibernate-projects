package org.aryalinux.eshoppe.data.dao;

import java.util.List;

import org.aryalinux.eshoppe.data.model.ProductCategory;
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
	public List<ProductCategory> getAllCategoriesRecursive() {
		String hql = "FROM ProductCategory category JOIN FETCH category.children WHERE category.parent=NULL";
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}
}
