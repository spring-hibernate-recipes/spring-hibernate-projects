package org.aryalinux.ezshoppe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.aryalinux.restapp.model.BaseEntity;

@Entity
public class Product extends BaseEntity {
	private String name;
	@ManyToOne(fetch = FetchType.EAGER)
	private ProductCategory category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

}
