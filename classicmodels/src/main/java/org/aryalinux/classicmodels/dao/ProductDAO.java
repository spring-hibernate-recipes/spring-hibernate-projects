package org.aryalinux.classicmodels.dao;

import java.util.List;

import org.aryalinux.classicmodels.model.Product;
import org.hibernate.Session;

public class ProductDAO extends GenericDAO<Product, String> {
	public ProductDAO() {
		super(Product.class);
	}

	public List<Product> getRandomProducts() {
		Session session = getSessionFactory().getCurrentSession();
		return null;
	}
}
