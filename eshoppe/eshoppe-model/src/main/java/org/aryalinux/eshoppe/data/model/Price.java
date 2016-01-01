package org.aryalinux.eshoppe.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
public class Price extends BaseEntity {
	@OneToOne(fetch = FetchType.LAZY)
	private Product product;
	@Column
	private Double markedPrice;
	@Column
	private Double discount;

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

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

}
