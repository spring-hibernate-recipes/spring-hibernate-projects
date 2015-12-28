package org.aryalinux.eshoppe.service;

import org.aryalinux.eshoppe.commons.request.CreateNewCategoryRequest;
import org.aryalinux.eshoppe.commons.response.CreateNewCategoryResponse;
import org.aryalinux.eshoppe.commons.response.GetAllCategoriesResponse;

public interface ProductCategoryService {
	CreateNewCategoryResponse createNewCategory(CreateNewCategoryRequest newCategoryRequest);

	GetAllCategoriesResponse getAllCategories();
}
