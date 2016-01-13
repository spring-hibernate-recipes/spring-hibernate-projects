package org.aryalinux.classicmodels.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.aryalinux.classicmodels.common.BaseResponse;
import org.aryalinux.classicmodels.dao.ProductDAO;
import org.aryalinux.classicmodels.dao.ProductLineDAO;
import org.aryalinux.classicmodels.model.Product;
import org.aryalinux.classicmodels.model.ProductLine;
import org.aryalinux.classicmodels.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ProductLineDAO productLineDAO;
	
	public BaseResponse getProductsByLine(String productLine) {
		BaseResponse baseResponse = null;
		try {
			Map<String, Object> params = new LinkedHashMap<String, Object>();
			ProductLine line = productLineDAO.getById(productLine);
			params.put("productLine", line);
			List<Product> products = productDAO.getByParams(params);
			baseResponse = new BaseResponse(1, "Products Found.");
			baseResponse.setData(products);
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, ex.getMessage());
			baseResponse.setData(ex);
		}
		return baseResponse;
	}

	public BaseResponse getPopularProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResponse getProductById(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
