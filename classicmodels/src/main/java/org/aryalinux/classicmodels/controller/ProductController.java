package org.aryalinux.classicmodels.controller;

import org.aryalinux.classicmodels.common.BaseResponse;
import org.aryalinux.classicmodels.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@ResponseBody
	@RequestMapping(path = "/rest/product/productline/{productLine}", method = RequestMethod.GET)
	public BaseResponse getProductsByProductLine(@PathVariable("productLine") String productLine) {
		return productService.getProductsByLine(productLine);
	}

	@ResponseBody
	@RequestMapping(path = "/rest/product/", method = RequestMethod.GET)
	public BaseResponse getProductByProductCode(@RequestParam(name = "code") String productCode) {
		return productService.getProductById(productCode);
	}

	public BaseResponse searchProducts(String keyword) {
		return null;
	}
}
