package org.aryalinux.ezshoppe.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.aryalinux.ezshoppe.commons.request.NewProductRequest;
import org.aryalinux.ezshoppe.commons.response.BaseResponse;
import org.aryalinux.ezshoppe.dao.ProductCategoryDAO;
import org.aryalinux.ezshoppe.dao.ProductDAO;
import org.aryalinux.ezshoppe.model.Price;
import org.aryalinux.ezshoppe.model.Product;
import org.aryalinux.ezshoppe.model.ProductCategory;
import org.aryalinux.ezshoppe.model.ProductProperty;
import org.aryalinux.ezshoppe.model.Stock;
import org.aryalinux.ezshoppe.service.ProductService;
import org.aryalinux.ezshoppe.service.util.ConversionMap;
import org.aryalinux.ezshoppe.service.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ProductCategoryDAO categoryDAO;

	public BaseResponse newProduct(NewProductRequest newProductRequest) {
		BaseResponse response = null;
		try {
			Product product = (Product) ObjectUtil.convert(newProductRequest, Product.class, new ConversionMap()
					.add("productCode", "productCode").add("name", "name").add("description", "description"));
			Stock stock = new Stock();
			stock.setCreatedDate(new Date());
			stock.setProduct(product);
			stock.setPresentStock(newProductRequest.getPresentStock());
			stock.setThreshold(newProductRequest.getThreshold());
			Price price = new Price();
			price.setProduct(product);
			price.setCreatedDate(new Date());
			price.setMarkedPrice(newProductRequest.getMarkedPrice());
			price.setSalePrice(newProductRequest.getSalePrice());
			List<ProductProperty> properties = new ArrayList<ProductProperty>();
			for (Entry<String, String> entry : newProductRequest.getProperties().entrySet()) {
				ProductProperty productProperty = new ProductProperty();
				productProperty.setCreatedDate(new Date());
				productProperty.setProduct(product);
				productProperty.setName(entry.getKey());
				productProperty.setValue(entry.getValue());
				properties.add(productProperty);
			}
			product.setStock(stock);
			product.setPrice(price);
			product.setProductProperties(properties);
			Integer id = productDAO.create(product);
			response = new BaseResponse(1, "Product created successfully.");
			response.addData("productId", id);
		} catch (Exception ex) {
			response = new BaseResponse(0, "Could not create product.");
		}
		return response;
	}

	public BaseResponse getProductById(Integer id) {
		BaseResponse response = null;
		Product product = productDAO.getById(id);
		if (product == null) {
			response = new BaseResponse(0, "Could not find product for given id.");
		} else {
			response = new BaseResponse(1, "Product found.");
			response.addData("products", ObjectUtil.convert(product));
		}
		return response;
	}

	public BaseResponse getProductByCategory(Integer categoryId) {
		BaseResponse response = null;
		ProductCategory category = categoryDAO.getById(categoryId);
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("category", category);
		List<Product> products = productDAO.getByCriteria(criteria);
		if (products != null && products.size() > 0) {
			response = new BaseResponse(1, "Products found for the given category.");
			response.addData("products", ObjectUtil.convert(products));
		} else {
			response = new BaseResponse(0, "No products found for the given category.");
		}
		return response;
	}

	public BaseResponse searchForProduct(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResponse delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResponse updateStock(Integer productId, Integer delta) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResponse updateThreshold(Integer productId, Integer newThreshold) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResponse updatePrice(Integer productId, Integer newMarkedPrice, Integer newSalePrice) {
		// TODO Auto-generated method stub
		return null;
	}

}
