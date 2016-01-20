package org.aryalinux.ezshoppe.dto;

import java.util.Date;

import org.aryalinux.ezshoppe.model.ProductCategory;
import org.aryalinux.restapptemplate.common.request.RestRequest;

public class ProductCategoryDTO implements RestRequest<ProductCategory> {
	private String name;
	private String description;
	private Integer parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public ProductCategory getData() {
		ProductCategory category = new ProductCategory();
		category.setName(name);
		category.setDescription(description);
		category.setCreatedDate(new Date());
		category.setUpdatedDate(new Date());
		return category;
	}

}
