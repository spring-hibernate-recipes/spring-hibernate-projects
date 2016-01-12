package org.aryalinux.ezshoppe.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.aryalinux.ezshoppe.common.BaseResponse;
import org.aryalinux.ezshoppe.common.request.NewProductRequest;
import org.aryalinux.ezshoppe.dao.ProductDAO;
import org.aryalinux.ezshoppe.model.Product;
import org.aryalinux.ezshoppe.model.Property;
import org.aryalinux.ezshoppe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;

	public BaseResponse newProduct(NewProductRequest productRequest) {
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setBrandName(productRequest.getBrand());
		product.setCreatedDate(new Date());
		product.setDescription(product.getDescription());
		product.setPrice(productRequest.getPrice());
		product.setProperties(new ArrayList<Property>());
		for (Entry<String, String> entry : productRequest.getProperties().entrySet()) {
			Property property = new Property();
			property.setCreatedDate(new Date());
			property.setName(entry.getKey());
			property.setValue(entry.getValue());
			product.getProperties().add(property);
		}
		Integer id = productDAO.create(product);
		BaseResponse baseResponse = new BaseResponse(1, "Product created successfully.");
		baseResponse.setData(id);
		return baseResponse;
	}

	public BaseResponse getAllProducts() {
		List<Product> products = productDAO.getAll();
		BaseResponse baseResponse = null;
		if (products != null && products.size() > 0) {
			baseResponse = new BaseResponse(1, "Products found.");
			baseResponse.setData(products);
		} else {
			baseResponse = new BaseResponse(0, "No products found.");
		}
		return baseResponse;
	}

	public BaseResponse getById(Integer id) {
		Product product = productDAO.getById(id);
		BaseResponse baseResponse = null;
		if (product != null) {
			baseResponse = new BaseResponse(1, "Product found.");
			baseResponse.setData(product);
		} else {
			baseResponse = new BaseResponse(0, "No products found.");
		}
		return baseResponse;
	}

}
