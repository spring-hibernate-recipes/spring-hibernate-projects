package org.aryalinux.eshoppe.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class OrderStatus extends BaseEntity {
	@Column
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
