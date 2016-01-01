package org.aryalinux.eshoppe.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aryalinux.eshoppe.commons.CategoryDTO;
import org.aryalinux.eshoppe.commons.request.NewCategoryRequest;
import org.aryalinux.eshoppe.commons.response.GetAllCategoriesResponse;
import org.aryalinux.eshoppe.commons.response.NewCategoryResponse;
import org.aryalinux.eshoppe.data.dao.CategoryDAO;
import org.aryalinux.eshoppe.data.model.ProductCategory;
import org.aryalinux.eshoppe.service.ProductCategoryService;
import org.aryalinux.eshoppe.utils.ConversionMap;
import org.aryalinux.eshoppe.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("productCategoryServiceImpl")
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private CategoryDAO categoryDAO;

	@Transactional
	public NewCategoryResponse createNewCategory(NewCategoryRequest newCategoryRequest) {
		NewCategoryResponse newCategoryResponse = new NewCategoryResponse();
		ConversionMap conversionMap = new ConversionMap().add("name", "name").add("description", "description")
				.add("imageUrls", "imageUrls").add("properties", "properties")
				.add("currentImageUrl", "currentImageUrl");
		ProductCategory category = (ProductCategory) ObjectUtil.convert(newCategoryRequest, ProductCategory.class,
				conversionMap);
		category.setActive(1);
		category.setCreatedDate(new Date());
		category.setUpdatedDate(new Date());

		if (newCategoryRequest.getParentCategoryId() != null && newCategoryRequest.getParentCategoryId() != -1) {
			ProductCategory parent = categoryDAO.findById(newCategoryRequest.getParentCategoryId());
			if (parent == null) {
				newCategoryResponse.setCode(0);
				newCategoryResponse.setMessage("Could not locate category with id "
						+ newCategoryRequest.getParentCategoryId() + " for update as parent.");
				return newCategoryResponse;
			} else {
				category.setParent(parent);
			}
		}

		Integer id = categoryDAO.create(category);
		newCategoryResponse.setCode(1);
		newCategoryResponse.setMessage("Category with id : " + id + " created successfully.");
		newCategoryResponse.setCategoryId(id);

		return newCategoryResponse;
	}

	public GetAllCategoriesResponse getAllCategories() {
		List<ProductCategory> categories = categoryDAO.getAllCategoriesRecursive();
		GetAllCategoriesResponse getAllCategoriesResponse = new GetAllCategoriesResponse();
		getAllCategoriesResponse.setCategories(new ArrayList<CategoryDTO>());
		for (ProductCategory category : categories) {
			getAllCategoriesResponse.getCategories().add(toDTO(category));
		}
		return getAllCategoriesResponse;
	}

	private CategoryDTO toDTO(ProductCategory productCategory) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCurrentImageUrl(productCategory.getCurrentImageUrl());
		categoryDTO.setDescription(productCategory.getDescription());
		categoryDTO.setId(productCategory.getId());
		categoryDTO.setImageUrls(productCategory.getImageUrls());
		categoryDTO.setProperties(productCategory.getProperties());
		for (ProductCategory category : productCategory.getChildren()) {
			categoryDTO.getChildren().add(toDTO(category));
		}
		return categoryDTO;
	}
}
