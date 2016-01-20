package org.aryalinux.ezshoppe.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.aryalinux.restapp.model.BaseEntity;

@Entity
public class ProductCategory extends BaseEntity {
	private String name;
	private String description;
	@OneToMany(fetch = FetchType.EAGER)
	private List<ProductCategory> children;

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

}
