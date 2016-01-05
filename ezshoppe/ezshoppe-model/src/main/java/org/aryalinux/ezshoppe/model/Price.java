package org.aryalinux.ezshoppe.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
public class Price extends BaseEntity {
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Product product;
	@Column(name = "marked_price")
	private Double markedPrice;
	@Column(name = "sale_price")
	private Double salePrice;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getMarkedPrice() {
		return markedPrice;
	}

	public void setMarkedPrice(Double markedPrice) {
		this.markedPrice = markedPrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

}
