package org.aryalinux.ezshoppe.controller;

import javax.servlet.http.HttpServletRequest;

import org.aryalinux.ezshoppe.common.BaseResponse;
import org.aryalinux.ezshoppe.common.request.NewProductRequest;
import org.aryalinux.ezshoppe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class ProductController {
	@Autowired
	private ProductService productService;

	@ResponseBody
	@RequestMapping(path = "/rest/product", method = RequestMethod.POST)
	public BaseResponse newProduct(HttpServletRequest request) {
		NewProductRequest productRequest = new NewProductRequest();
		productRequest.setName(request.getParameter("name"));
		productRequest.setDescription(request.getParameter("description"));
		productRequest.setBrand(request.getParameter("brand"));
		productRequest.setPrice(Double.parseDouble(request.getParameter("price")));
		productRequest.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
		String[] names = request.getParameterValues("propertyName");
		String[] values = request.getParameterValues("propertyValue");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
			System.out.println(values[i]);
			productRequest.getProperties().put(names[i], values[i]);
		}
		return productService.newProduct(productRequest);
	}
}
