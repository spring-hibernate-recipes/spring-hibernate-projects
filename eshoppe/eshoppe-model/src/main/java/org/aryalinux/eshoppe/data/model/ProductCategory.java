package org.aryalinux.eshoppe.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productCategories")
public class ProductCategory extends BaseEntity {
	@Column
	private String name;
	@Column
	private String description;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private Set<ProductCategory> children;
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "productCategoryProperties", joinColumns = @JoinColumn(name = "productCategoryId") )
	private Set<String> properties;
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "productCategoryImages", joinColumns = @JoinColumn(name = "productCategoryId") )
	private Set<String> imageUrls;
	@Column
	private String currentImageUrl;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ProductCategory parent;

	public ProductCategory() {
		children = new HashSet<ProductCategory>();
		properties = new HashSet<String>();
		imageUrls = new HashSet<String>();
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

	public Set<ProductCategory> getChildren() {
		return children;
	}

	public void setChildren(Set<ProductCategory> children) {
		this.children = children;
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

	public Set<String> getProperties() {
		return properties;
	}

	public void setProperties(Set<String> properties) {
		this.properties = properties;
	}

	public ProductCategory getParent() {
		return parent;
	}

	public void setParent(ProductCategory parent) {
		this.parent = parent;
	}
}
