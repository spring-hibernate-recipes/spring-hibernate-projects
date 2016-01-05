package org.aryalinux.ezshoppe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	@Column(name = "present_stock")
	private Integer presentStock;
	@Column(name = "threshold")
	private Integer threshold;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getPresentStock() {
		return presentStock;
	}

	public void setPresentStock(Integer presentStock) {
		this.presentStock = presentStock;
	}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

}
