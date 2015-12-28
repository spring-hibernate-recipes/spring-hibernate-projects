package org.aryalinux.eshoppe.rest.controller;

import org.aryalinux.eshoppe.commons.request.CreateNewCategoryRequest;
import org.aryalinux.eshoppe.commons.response.CreateNewCategoryResponse;
import org.aryalinux.eshoppe.commons.response.GetAllCategoriesResponse;
import org.aryalinux.eshoppe.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/services")
public class CategoryController {
	@Autowired
	private ProductCategoryService productCategoryService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, path = "/category")
	public CreateNewCategoryResponse createNewCategory(@RequestBody CreateNewCategoryRequest createNewCategoryRequest) {
		return productCategoryService.createNewCategory(createNewCategoryRequest);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, path = "/category")
	public GetAllCategoriesResponse getAllCategories() {
		return productCategoryService.getAllCategories();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, path = "/sayhello")
	public String sayHello(@RequestParam(name = "name") String name) {
		return "Hello " + name + "!";
	}
}
