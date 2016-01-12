package org.aryalinux.ezshoppe.controller;

import org.aryalinux.ezshoppe.common.BaseResponse;
import org.aryalinux.ezshoppe.common.request.NewCategoryRequest;
import org.aryalinux.ezshoppe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping(path = "/category", method = RequestMethod.POST)
	public BaseResponse createNewCategory(NewCategoryRequest categoryRequest) {
		return categoryService.newCategory(categoryRequest);
	}

	@ResponseBody
	@RequestMapping(path = "/category", method = RequestMethod.GET)
	public BaseResponse getAllCategories() {
		return categoryService.getAllCategories();
	}

	@ResponseBody
	@RequestMapping(path = "/category/top", method = RequestMethod.GET)
	public BaseResponse getTopLevelCategories() {
		return categoryService.getTopLevelCategories();
	}
}
