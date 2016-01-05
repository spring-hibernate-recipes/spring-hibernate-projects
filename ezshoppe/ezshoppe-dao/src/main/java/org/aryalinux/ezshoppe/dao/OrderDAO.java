package org.aryalinux.ezshoppe.dao;

import org.aryalinux.ezshoppe.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO extends GenericDAO<Order, Integer> {
	public OrderDAO() {
		super(Order.class);
	}
}
