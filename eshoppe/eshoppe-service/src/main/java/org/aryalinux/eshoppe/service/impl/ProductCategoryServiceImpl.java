package org.aryalinux.eshoppe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.aryalinux.eshoppe.commons.request.CreateNewCategoryRequest;
import org.aryalinux.eshoppe.commons.response.CreateNewCategoryResponse;
import org.aryalinux.eshoppe.commons.response.GetAllCategoriesResponse;
import org.aryalinux.eshoppe.data.dao.GenericDAO;
import org.aryalinux.eshoppe.data.model.Category;
import org.aryalinux.eshoppe.service.ProductCategoryService;
import org.aryalinux.eshoppe.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private GenericDAO<Category, Integer> categoryDAO;

	public CreateNewCategoryResponse createNewCategory(CreateNewCategoryRequest newCategoryRequest) {
		Integer id = categoryDAO.create((Category) ObjectUtil.transferState(newCategoryRequest, Category.class));
		CreateNewCategoryResponse createNewCategoryResponse = new CreateNewCategoryResponse();
		createNewCategoryResponse.setCode(1);
		createNewCategoryResponse.setMessage("Success");
		createNewCategoryResponse.setCategoryId(id);
		return createNewCategoryResponse;
	}

	public GetAllCategoriesResponse getAllCategories() {
		List<Category> categories = categoryDAO.fetchAll();
		GetAllCategoriesResponse getAllCategoriesResponse = new GetAllCategoriesResponse();
		getAllCategoriesResponse.setCategories(new ArrayList<org.aryalinux.eshoppe.commons.response.Category>());
		for (Category category : categories) {
			org.aryalinux.eshoppe.commons.response.Category category2 = (org.aryalinux.eshoppe.commons.response.Category) ObjectUtil
					.transferState(category, org.aryalinux.eshoppe.commons.response.Category.class);
			getAllCategoriesResponse.getCategories().add(category2);
			for (Category category3 : category.getChildren()) {
				org.aryalinux.eshoppe.commons.response.Category category4 = (org.aryalinux.eshoppe.commons.response.Category) ObjectUtil
						.transferState(category3, org.aryalinux.eshoppe.commons.response.Category.class);
				category2.getChildren().add(category4);
			}
			getAllCategoriesResponse.getCategories().add(category2);
		}
		return getAllCategoriesResponse;
	}

}
