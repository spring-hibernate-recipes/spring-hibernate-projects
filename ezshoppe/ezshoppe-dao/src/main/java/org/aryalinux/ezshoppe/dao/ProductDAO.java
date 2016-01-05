package org.aryalinux.ezshoppe.dao;

import org.aryalinux.ezshoppe.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO extends GenericDAO<Product, Integer> {
	public ProductDAO() {
		super(Product.class);
	}
}
