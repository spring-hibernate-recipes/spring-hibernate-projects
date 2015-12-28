package org.aryalinux.eshoppe.data.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderFulfilment extends BaseEntity {
	@OneToOne
	private Order order;
	@OneToMany
	private List<OrderStatusUpdate> orderStatusUpdates;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderStatusUpdate> getOrderStatusUpdates() {
		return orderStatusUpdates;
	}

	public void setOrderStatusUpdates(List<OrderStatusUpdate> orderStatusUpdates) {
		this.orderStatusUpdates = orderStatusUpdates;
	}

}
