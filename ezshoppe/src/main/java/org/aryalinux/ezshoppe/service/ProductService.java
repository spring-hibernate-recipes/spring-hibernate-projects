package org.aryalinux.ezshoppe.service;

import org.aryalinux.ezshoppe.common.BaseResponse;
import org.aryalinux.ezshoppe.common.request.NewProductRequest;

public interface ProductService {
	BaseResponse newProduct(NewProductRequest productRequest);

	BaseResponse getAllProducts();

	BaseResponse getById(Integer id);
}
