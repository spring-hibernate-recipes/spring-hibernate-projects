package org.aryalinux.ezshoppe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class ProductCategory extends BaseEntity {
	@Column(name = "name", length = 64)
	private String name;
	@Column(name = "description")
	private String description;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ProductCategory> children;
	@Column(name = "top_level")
	private Integer topLevel;

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

	public List<ProductCategory> getChildren() {
		return children;
	}

	public void setChildren(List<ProductCategory> children) {
		this.children = children;
	}

	public Integer getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(Integer topLevel) {
		this.topLevel = topLevel;
	}

}
