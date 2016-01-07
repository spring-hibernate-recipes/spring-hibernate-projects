package org.aryalinux.ezshoppe.service;

import org.aryalinux.ezshoppe.commons.request.NewCategoryRequest;
import org.aryalinux.ezshoppe.commons.response.BaseResponse;

public interface CategoryService {
	BaseResponse newCategory(NewCategoryRequest newCategoryRequest);

	BaseResponse getTopLevelCategories();

	BaseResponse getAllCategories();
}
