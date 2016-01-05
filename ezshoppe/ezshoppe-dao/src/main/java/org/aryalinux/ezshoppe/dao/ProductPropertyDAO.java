package org.aryalinux.ezshoppe.dao;

import org.aryalinux.ezshoppe.model.ProductProperty;
import org.springframework.stereotype.Component;

@Component
public class ProductPropertyDAO extends GenericDAO<ProductProperty, Integer> {
	public ProductPropertyDAO() {
		super(ProductProperty.class);
	}
}
