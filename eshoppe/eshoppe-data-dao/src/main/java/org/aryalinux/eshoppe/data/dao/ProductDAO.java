package org.aryalinux.eshoppe.data.dao;

import org.aryalinux.eshoppe.data.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO extends GenericDAO<Product, Integer> {
	public ProductDAO() {
		super(Product.class);
	}
}
