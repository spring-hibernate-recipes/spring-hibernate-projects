package org.aryalinux.eshoppe.commons.response;

import java.util.List;

import org.aryalinux.eshoppe.commons.CategoryDTO;

public class GetAllCategoriesResponse extends BaseResponse {
	private List<CategoryDTO> categories;

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}

}
