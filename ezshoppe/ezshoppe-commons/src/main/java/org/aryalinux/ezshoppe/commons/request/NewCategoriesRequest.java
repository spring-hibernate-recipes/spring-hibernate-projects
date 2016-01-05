package org.aryalinux.ezshoppe.commons.request;

import java.util.ArrayList;
import java.util.List;

public class NewCategoriesRequest {
	private List<NewCategoryRequest> categories;

	public NewCategoriesRequest() {
		categories = new ArrayList<NewCategoryRequest>();
	}

	public List<NewCategoryRequest> getCategories() {
		return categories;
	}

	public void setCategories(List<NewCategoryRequest> categories) {
		this.categories = categories;
	}

}
