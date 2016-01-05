package org.aryalinux.ezshoppe.dao;

import org.aryalinux.ezshoppe.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemDAO extends GenericDAO<OrderItem, Integer> {
	public OrderItemDAO() {
		super(OrderItem.class);
	}
}
