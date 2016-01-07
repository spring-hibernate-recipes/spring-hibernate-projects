package org.aryalinux.ezshoppe.rest.controller;

import org.aryalinux.ezshoppe.commons.request.NewCategoryRequest;
import org.aryalinux.ezshoppe.commons.response.BaseResponse;
import org.aryalinux.ezshoppe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/rest")
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
	public BaseResponse createNewCategory(@RequestParam(name = "name") String name,
			@RequestParam(name = "label") String label, @RequestParam(name = "topLevel") String topLevel,
			@RequestParam(name = "image") MultipartFile image,
			@RequestParam(name = "parentCategoryId") Integer parentCategoryId) {
		NewCategoryRequest categoryRequest = new NewCategoryRequest();
		categoryRequest.setName(name);
		categoryRequest.setLabel(label);
		categoryRequest.setTopLevel(topLevel);
		categoryRequest.setParentCategoryId(parentCategoryId);
		categoryRequest.setImage(image.toString());
		return categoryService.newCategory(categoryRequest);
	}
}
