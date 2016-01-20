package org.aryalinux.ezshoppe.dao;

import org.aryalinux.ezshoppe.model.ProductCategory;
import org.aryalinux.restapptemplate.dao.GenericDAO;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryDAO extends GenericDAO<ProductCategory, Integer> {
	public ProductCategoryDAO() {
		super(ProductCategory.class);
	}
}
