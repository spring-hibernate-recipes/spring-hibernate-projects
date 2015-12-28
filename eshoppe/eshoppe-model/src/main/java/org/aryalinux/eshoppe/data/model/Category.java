package org.aryalinux.eshoppe.data.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category extends BaseEntity {
	@Column
	private String name;
	@Column
	private String description;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Category> children;
	@ElementCollection
	private List<String> properties;
	@ElementCollection
	private List<String> imageUrls;
	@Column
	private String currentImageUrl;
	@ManyToOne(fetch = FetchType.LAZY)
	private Category parent;

	public Category() {
		children = new ArrayList<Category>();
		properties = new ArrayList<String>();
		imageUrls = new ArrayList<String>();
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

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
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

	public List<String> getProperties() {
		return properties;
	}

	public void setProperties(List<String> properties) {
		this.properties = properties;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

}
