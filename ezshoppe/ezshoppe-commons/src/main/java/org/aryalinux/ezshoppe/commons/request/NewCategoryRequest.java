package org.aryalinux.ezshoppe.commons.request;

public class NewCategoryRequest {
	private String name;
	private Integer parentCategoryId;
	private String image;
	private String label;
	private String topLevel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(String topLevel) {
		this.topLevel = topLevel;
	}

}
