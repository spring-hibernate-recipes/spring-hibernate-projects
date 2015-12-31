package org.aryalinux.eshoppe.data.dao;

import org.aryalinux.eshoppe.data.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class CategoryDAO extends GenericDAO<ProductCategory, Integer> {

	public CategoryDAO() {
		super(ProductCategory.class);
	}
}
