package org.aryalinux.classicmodels.service;

import org.aryalinux.classicmodels.common.BaseResponse;

public interface ProductService {
	BaseResponse getProductsByLine(String productLine);

	BaseResponse getPopularProducts();

	BaseResponse getProductById(String productCode);
}
