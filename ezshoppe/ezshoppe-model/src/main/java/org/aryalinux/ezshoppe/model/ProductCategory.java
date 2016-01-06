package org.aryalinux.ezshoppe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_categories")
public class ProductCategory extends BaseEntity {
	@Column
	private String name;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ProductCategory> children;
	@Column(name = "image_url")
	private String imageUrl;
	@Column
	private String label;
	@Column
	private Integer topLevel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductCategory> getChildren() {
		return children;
	}

	public void setChildren(List<ProductCategory> children) {
		this.children = children;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(Integer topLevel) {
		this.topLevel = topLevel;
	}

}
