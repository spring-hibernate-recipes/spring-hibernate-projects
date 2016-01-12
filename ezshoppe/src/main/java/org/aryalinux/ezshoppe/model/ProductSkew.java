package org.aryalinux.ezshoppe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProductSkew extends BaseEntity {
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Product product;
	@Column
	private String skewName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Property> properties;
	@Column
	private Double price;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSkewName() {
		return skewName;
	}

	public void setSkewName(String skewName) {
		this.skewName = skewName;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
