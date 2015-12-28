package org.aryalinux.eshoppe.commons.response;

import java.util.List;

public class GetAllCategoriesResponse extends BaseResponse {
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
