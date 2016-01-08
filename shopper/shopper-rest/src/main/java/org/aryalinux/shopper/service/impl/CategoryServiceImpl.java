package org.aryalinux.shopper.service.impl;

import java.util.Date;
import java.util.List;

import org.aryalinux.shopper.data.dao.CategoryDAO;
import org.aryalinux.shopper.data.model.ProductCategory;
import org.aryalinux.shopper.rest.request.NewCategoryRequest;
import org.aryalinux.shopper.rest.response.BaseResponse;
import org.aryalinux.shopper.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;

	public BaseResponse newCategory(NewCategoryRequest categoryRequest) {
		ProductCategory category = new ProductCategory();
		category.setCreatedDate(new Date());
		category.setName(categoryRequest.getName());
		category.setDescription(categoryRequest.getDescription());
		ProductCategory parent = categoryDAO.getById(Integer.parseInt(categoryRequest.getParentId()));
		category.setParent(parent);
		Integer id = categoryDAO.create(category);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(1);
		baseResponse.setMessage("Category created successfully.");
		baseResponse.setData(id);
		return baseResponse;
	}

	public BaseResponse getAllCategories() {
		List<ProductCategory> categories = categoryDAO.listAll();
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(1);
		baseResponse.setMessage("Successfully fetched all categories");
		baseResponse.setData(categories);
		return baseResponse;
	}

	public BaseResponse deleteCategory(Integer id) {
		BaseResponse baseResponse = new BaseResponse();
		try {
			ProductCategory category = categoryDAO.getById(id);
			categoryDAO.delete(category);
			baseResponse.setCode(1);
			baseResponse.setMessage("Category deleted.");
		} catch (Exception ex) {

			baseResponse.setCode(0);
			baseResponse.setMessage("Category could not be deleted.");
			baseResponse.setData(ex.getMessage());
		}
		return baseResponse;
	}

}
