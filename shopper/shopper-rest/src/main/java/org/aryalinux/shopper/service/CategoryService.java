package org.aryalinux.shopper.service;

import org.aryalinux.shopper.rest.request.NewCategoryRequest;
import org.aryalinux.shopper.rest.response.BaseResponse;

public interface CategoryService {
	BaseResponse newCategory(NewCategoryRequest categoryRequest);

	BaseResponse getAllCategories();

	BaseResponse deleteCategory(Integer id);
}
