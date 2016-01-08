package org.aryalinux.shopper.data.dao;

import java.util.List;

import org.aryalinux.shopper.data.model.ProductCategory;

public interface CategoryDAO {
	Integer create(ProductCategory category);

	void delete(ProductCategory category);

	List<ProductCategory> listAll();

	ProductCategory getById(Integer id);

	void update(ProductCategory category);
}
