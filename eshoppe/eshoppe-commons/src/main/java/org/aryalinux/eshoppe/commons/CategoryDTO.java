package org.aryalinux.eshoppe.commons;

import java.util.List;

public class CategoryDTO {
	private String name;
	private String description;
	private List<CategoryDTO> children;
	private List<String> properties;
	private List<String> imageUrls;
	private String currentImageUrl;

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

	public List<CategoryDTO> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryDTO> children) {
		this.children = children;
	}

	public List<String> getProperties() {
		return properties;
	}

	public void setProperties(List<String> properties) {
		this.properties = properties;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getCurrentImageUrl() {
		return currentImageUrl;
	}

	public void setCurrentImageUrl(String currentImageUrl) {
		this.currentImageUrl = currentImageUrl;
	}

}
