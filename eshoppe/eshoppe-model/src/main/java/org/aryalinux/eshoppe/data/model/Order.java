package org.aryalinux.eshoppe.data.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	@Temporal(TemporalType.TIMESTAMP)
	private Date placedOn;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
	private List<OrderItem> orderItems;
	@Column
	private String specialInstructions;
	@OneToOne
	private OrderStatusUpdate currentStatusUpdate;
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	public Date getPlacedOn() {
		return placedOn;
	}

	public void setPlacedOn(Date placedOn) {
		this.placedOn = placedOn;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public OrderStatusUpdate getCurrentStatusUpdate() {
		return currentStatusUpdate;
	}

	public void setCurrentStatusUpdate(OrderStatusUpdate currentStatusUpdate) {
		this.currentStatusUpdate = currentStatusUpdate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
