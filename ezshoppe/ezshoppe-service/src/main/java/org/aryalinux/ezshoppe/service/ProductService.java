package org.aryalinux.ezshoppe.service;

import org.aryalinux.ezshoppe.commons.request.NewProductRequest;
import org.aryalinux.ezshoppe.commons.response.BaseResponse;

public interface ProductService {
	BaseResponse newProduct(NewProductRequest newProductRequest);

	BaseResponse getProductById(Integer id);

	BaseResponse getProductByCategory(Integer categoryId);

	BaseResponse searchForProduct(String keywords);

	BaseResponse delete(Integer id);

	BaseResponse updateStock(Integer productId, Integer delta);

	BaseResponse updateThreshold(Integer productId, Integer newThreshold);

	BaseResponse updatePrice(Integer productId, Integer newMarkedPrice, Integer newSalePrice);
}
