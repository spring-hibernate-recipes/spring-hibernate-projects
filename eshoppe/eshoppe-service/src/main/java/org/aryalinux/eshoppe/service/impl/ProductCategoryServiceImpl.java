package org.aryalinux.eshoppe.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aryalinux.eshoppe.commons.CategoryDTO;
import org.aryalinux.eshoppe.commons.request.NewCategoryRequest;
import org.aryalinux.eshoppe.commons.response.NewCategoryResponse;
import org.aryalinux.eshoppe.commons.response.GetAllCategoriesResponse;
import org.aryalinux.eshoppe.data.dao.GenericDAO;
import org.aryalinux.eshoppe.data.model.ProductCategory;
import org.aryalinux.eshoppe.service.ProductCategoryService;
import org.aryalinux.eshoppe.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("productCategoryServiceImpl")
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private GenericDAO<ProductCategory, Integer> categoryDAO;

	@Transactional
	public NewCategoryResponse createNewCategory(NewCategoryRequest newCategoryRequest) {
		NewCategoryResponse createNewCategoryResponse = new NewCategoryResponse();
		ProductCategory category = (ProductCategory) ObjectUtil.transferState(newCategoryRequest, ProductCategory.class);
		category.setActive(1);
		category.setCreatedDate(new Date());

		if (newCategoryRequest.getParentCategoryId() != null) {
			ProductCategory parent = categoryDAO.findById(newCategoryRequest.getParentCategoryId());
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
		List<ProductCategory> categories = categoryDAO.fetchAll();
		GetAllCategoriesResponse getAllCategoriesResponse = new GetAllCategoriesResponse();
		getAllCategoriesResponse.setCategories(new ArrayList<CategoryDTO>());
		for (ProductCategory category : categories) {
			CategoryDTO category2 = (CategoryDTO) ObjectUtil.transferState(category, CategoryDTO.class);
			getAllCategoriesResponse.getCategories().add(category2);
			for (ProductCategory category3 : category.getChildren()) {
				CategoryDTO category4 = (CategoryDTO) ObjectUtil.transferState(category3, CategoryDTO.class);
				category2.getChildren().add(category4);
			}
			getAllCategoriesResponse.getCategories().add(category2);
		}
		return getAllCategoriesResponse;
	}

}
