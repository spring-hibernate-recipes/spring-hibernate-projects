package org.aryalinux.ezshoppe.service;

import org.aryalinux.ezshoppe.common.BaseResponse;
import org.aryalinux.ezshoppe.common.request.NewCategoryRequest;

public interface CategoryService {
	BaseResponse newCategory(NewCategoryRequest newCategoryRequest);

	BaseResponse getAllCategories();

	BaseResponse getTopLevelCategories();
}
