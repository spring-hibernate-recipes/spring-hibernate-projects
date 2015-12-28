package org.aryalinux.eshoppe.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.transaction.annotation.Transactional;

@Component("productCategoryServiceImpl")
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private GenericDAO<Category, Integer> categoryDAO;

	@Transactional
	public CreateNewCategoryResponse createNewCategory(CreateNewCategoryRequest newCategoryRequest) {
		CreateNewCategoryResponse createNewCategoryResponse = new CreateNewCategoryResponse();
		Category category = (Category) ObjectUtil.transferState(newCategoryRequest, Category.class);
		category.setActive(1);
		category.setCreatedDate(new Date());

		if (newCategoryRequest.getParentCategoryId() != null) {
			Category parent = categoryDAO.findById(newCategoryRequest.getParentCategoryId());
			if (parent == null) {
				createNewCategoryResponse.setCode(0);
				createNewCategoryResponse.setMessage("Could not locate category with id "
						+ newCategoryRequest.getParentCategoryId() + " for update as parent.");
				return createNewCategoryResponse;
			} else {
				category.setParent(parent);
			}
		}

		Integer id = categoryDAO.create(category);
		createNewCategoryResponse.setCode(1);
		createNewCategoryResponse.setMessage("Category with id : " + id + " created successfully.");
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
