package org.aryalinux.classicmodels.dao;

import java.util.List;

import org.aryalinux.classicmodels.model.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductDAO extends GenericDAO<Product, String> {
	public ProductDAO() {
		super(Product.class);
	}

	@Transactional
	public List<Product> getRandomProducts() {
		Session session = getSessionFactory().getCurrentSession();
		return null;
	}
}
