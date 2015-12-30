package org.aryalinux.eshoppe.data.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrderStatusUpdate extends BaseEntity {
	@OneToOne
	private OrderStatus orderStatus;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	@ManyToOne(fetch = FetchType.LAZY)
	private OrderFulfilment orderFulfilment;

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
