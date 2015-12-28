package org.aryalinux.eshoppe.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Stock extends BaseEntity {
	@OneToOne
	private Product product;
	@Column
	private Integer currentStock;
	@Column
	private Integer threshold;
	@OneToOne
	private Warehouse warehouse;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}
