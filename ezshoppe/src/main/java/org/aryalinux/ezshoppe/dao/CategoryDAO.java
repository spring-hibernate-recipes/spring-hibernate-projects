package org.aryalinux.ezshoppe.dao;

import org.aryalinux.ezshoppe.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class CategoryDAO extends GenericDAO<ProductCategory, Integer> {
	public CategoryDAO() {
		super(ProductCategory.class);
	}
}
