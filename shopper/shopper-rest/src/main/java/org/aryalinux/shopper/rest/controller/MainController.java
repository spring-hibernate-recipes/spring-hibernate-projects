package org.aryalinux.shopper.rest.controller;

import org.aryalinux.shopper.rest.request.NewCategoryRequest;
import org.aryalinux.shopper.rest.response.BaseResponse;
import org.aryalinux.shopper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping(path = "/category", method = RequestMethod.GET)
	public BaseResponse getAllCategories() {
		return categoryService.getAllCategories();
	}

	@ResponseBody
	@RequestMapping(path = "/category", method = RequestMethod.POST)
	public String newCategory(@RequestBody NewCategoryRequest categoryRequest) {

		return "success";
	}
}
