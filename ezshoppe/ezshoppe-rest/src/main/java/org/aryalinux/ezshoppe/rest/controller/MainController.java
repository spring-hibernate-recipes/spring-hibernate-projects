package org.aryalinux.ezshoppe.rest.controller;

import org.aryalinux.ezshoppe.commons.response.BaseResponse;
import org.aryalinux.ezshoppe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/rest")
public class MainController {
	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping(path = "/category", method = RequestMethod.GET)
	public BaseResponse getAllCategories() {
		return categoryService.getTopLevelCategories();
	}
}
