package org.aryalinux.classicmodels.service;

import org.aryalinux.classicmodels.common.BaseResponse;
import org.aryalinux.classicmodels.common.request.NewProductLineRequest;

public interface ProductLineService {
	BaseResponse newProductLine(NewProductLineRequest productLineRequest);

	BaseResponse getAllProductLines();

	BaseResponse deleteProductLine(String name);

	BaseResponse updateProductLine(NewProductLineRequest productLineRequest);
	
	BaseResponse getProductLineByName(String productLine);
}
