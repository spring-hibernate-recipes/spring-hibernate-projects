package org.aryalinux.eshoppe.commons;

import java.util.Set;

public class CategoryDTO {
	private Integer id;
	private String name;
	private String description;
	private Set<CategoryDTO> children;
	private Set<String> properties;
	private Set<String> imageUrls;
	private String currentImageUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Set<CategoryDTO> getChildren() {
		return children;
	}

	public void setChildren(Set<CategoryDTO> children) {
		this.children = children;
	}

	public Set<String> getProperties() {
		return properties;
	}

	public void setProperties(Set<String> properties) {
		this.properties = properties;
	}

	public Set<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(Set<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getCurrentImageUrl() {
		return currentImageUrl;
	}

	public void setCurrentImageUrl(String currentImageUrl) {
		this.currentImageUrl = currentImageUrl;
	}

}
