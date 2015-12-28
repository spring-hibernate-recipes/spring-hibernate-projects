package org.aryalinux.eshoppe.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class OrderItem extends BaseEntity {
	@Column
	private String description;
	@OneToOne
	private Product product;
	@Column
	private Integer quantity;
	@Column
	private Double price;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
