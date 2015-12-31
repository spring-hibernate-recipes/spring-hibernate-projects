package org.aryalinux.eshoppe.service;

import org.aryalinux.eshoppe.commons.request.NewCategoryRequest;
import org.aryalinux.eshoppe.commons.response.NewCategoryResponse;
import org.aryalinux.eshoppe.commons.response.GetAllCategoriesResponse;

public interface ProductCategoryService {
	NewCategoryResponse createNewCategory(NewCategoryRequest newCategoryRequest);

	GetAllCategoriesResponse getAllCategories();
}
