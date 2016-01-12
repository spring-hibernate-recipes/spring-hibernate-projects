package org.aryalinux.ezshoppe.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aryalinux.ezshoppe.common.BaseResponse;
import org.aryalinux.ezshoppe.common.request.NewCategoryRequest;
import org.aryalinux.ezshoppe.dao.CategoryDAO;
import org.aryalinux.ezshoppe.model.ProductCategory;
import org.aryalinux.ezshoppe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;

	public BaseResponse newCategory(NewCategoryRequest newCategoryRequest) {
		ProductCategory category = new ProductCategory();
		category.setName(newCategoryRequest.getName());
		category.setDescription(newCategoryRequest.getDescription());
		category.setTopLevel(1);
		ProductCategory parent = null;
		if (newCategoryRequest.getParentId() != null) {
			parent = categoryDAO.getById(newCategoryRequest.getParentId());
		}
		if (parent != null) {
			if (parent.getChildren() == null) {
				parent.setChildren(new ArrayList<ProductCategory>());
			}
			category.setTopLevel(0);
			parent.getChildren().add(category);
		}
		Integer id = categoryDAO.create(category);
		if (parent != null) {
			categoryDAO.update(parent);
		}
		BaseResponse baseResponse = new BaseResponse(1, "New Category created successfully.");
		baseResponse.setData(id);
		return baseResponse;
	}

	public BaseResponse getAllCategories() {
		List<ProductCategory> categories = categoryDAO.getAll();
		BaseResponse baseResponse;
		if (categories != null && categories.size() > 0) {
			baseResponse = new BaseResponse(1, "Categories found.");
			baseResponse.setData(categories);
		} else {
			baseResponse = new BaseResponse(0, "No categories found.");
		}
		return baseResponse;
	}

	public BaseResponse getTopLevelCategories() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("topLevel", 1);
		List<ProductCategory> categories = categoryDAO.getByCriteria(params);
		BaseResponse baseResponse;
		if (categories != null && categories.size() > 0) {
			baseResponse = new BaseResponse(1, "Categories found.");
			baseResponse.setData(categories);
		} else {
			baseResponse = new BaseResponse(0, "No categories found.");
		}
		return baseResponse;
	}
}
