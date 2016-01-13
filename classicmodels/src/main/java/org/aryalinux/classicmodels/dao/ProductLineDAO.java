package org.aryalinux.classicmodels.dao;

import org.aryalinux.classicmodels.model.ProductLine;
import org.springframework.stereotype.Component;

@Component
public class ProductLineDAO extends GenericDAO<ProductLine, String> {
	public ProductLineDAO() {
		super(ProductLine.class);
	}
}
