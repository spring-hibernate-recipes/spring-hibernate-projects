package org.aryalinux.ezshoppe.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aryalinux.ezshoppe.commons.request.NewCategoryRequest;
import org.aryalinux.ezshoppe.commons.response.BaseResponse;
import org.aryalinux.ezshoppe.dao.ProductCategoryDAO;
import org.aryalinux.ezshoppe.model.ProductCategory;
import org.aryalinux.ezshoppe.service.CategoryService;
import org.aryalinux.ezshoppe.service.util.ConversionMap;
import org.aryalinux.ezshoppe.service.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private ProductCategoryDAO categoryDAO;

	public BaseResponse newCategory(NewCategoryRequest newCategoryRequest) {
		ProductCategory category = (ProductCategory) ObjectUtil.convert(newCategoryRequest, ProductCategory.class,
				new ConversionMap().add("name", "name").add("label", "label").add("imageUrl", "imageUrl"));
		System.out.println(newCategoryRequest.getTopLevel());
		ProductCategory parent = categoryDAO.getById(newCategoryRequest.getParentCategoryId());
		parent.getChildren().add(category);
		Integer id = categoryDAO.create(category);
		categoryDAO.update(parent);
		BaseResponse response = new BaseResponse(1, "Product Category Created Successfully");
		response.addData("categoryId", id);
		return response;
	}

	public BaseResponse getTopLevelCategories() {
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("topLevel", 1);
		List<ProductCategory> categories = categoryDAO.getByCriteria(criteria);
		BaseResponse baseResponse = new BaseResponse(1, "Categories found");
		baseResponse.addData("categories", ObjectUtil.convert(categories));
		return baseResponse;
	}

	public BaseResponse getAllCategories() {
		List<ProductCategory> categories = categoryDAO.getAll();
		BaseResponse baseResponse = new BaseResponse(1, "Found categories");
		baseResponse.addData("categories", categories);
		return baseResponse;
	}

}
