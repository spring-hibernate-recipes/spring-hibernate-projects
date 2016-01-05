package org.aryalinux.ezshoppe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_properties")
public class ProductProperty extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	private Product product;
	@Column
	private String name;
	@Column
	private String value;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
