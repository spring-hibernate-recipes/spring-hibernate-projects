package org.aryalinux.ezshoppe.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.aryalinux.ezshoppe.commons.request.NewOrderRequest;
import org.aryalinux.ezshoppe.commons.response.BaseResponse;
import org.aryalinux.ezshoppe.dao.CustomerDAO;
import org.aryalinux.ezshoppe.dao.OrderDAO;
import org.aryalinux.ezshoppe.dao.OrderItemDAO;
import org.aryalinux.ezshoppe.model.Customer;
import org.aryalinux.ezshoppe.model.Order;
import org.aryalinux.ezshoppe.model.OrderItem;
import org.aryalinux.ezshoppe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderItemDAO orderItemDAO;
	@Autowired
	private CustomerDAO customerDAO;

	public BaseResponse newOrder(NewOrderRequest newOrderRequest) {
		Customer customer = customerDAO.getById(newOrderRequest.getCustomerId());
		Order order = new Order();
		order.setCustomer(customer);
		order.setCreatedDate(new Date());
		Integer id = orderDAO.create(order);
		BaseResponse baseResponse = new BaseResponse(1, "Order Created Successfully.");
		baseResponse.addData("orderId", id);
		return baseResponse;
	}

	public BaseResponse addItem(Integer orderId, Integer productId, Integer quantity, String type, String description) {
		Order order = orderDAO.getById(orderId);
		OrderItem orderItem = new OrderItem();
		orderItem.setCreatedDate(new Date());
		orderItem.setUpdatedDate(new Date());
		orderItem.setOrder(order);
		orderItem.setDescription(description);
		orderItem.setType(type);
		order.setOrderItems(new ArrayList<OrderItem>());
		order.getOrderItems().add(orderItem);
		Integer id = orderItemDAO.create(orderItem);
		BaseResponse baseResponse = new BaseResponse(1, "Item added to orders.");
		baseResponse.addData("orderItemId", id);
		return baseResponse;
	}

	public BaseResponse removeItem(Integer orderId, Integer itemId) {
		BaseResponse baseResponse = null;
		try {
			OrderItem orderItem = orderItemDAO.getById(itemId);
			orderItemDAO.delete(orderItem);
			baseResponse = new BaseResponse(1, "Order Item deleted successfully");
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, "Could not delete item from order.");
		}
		return baseResponse;
	}

	public BaseResponse checkout(Integer orderId) {
		BaseResponse baseResponse = null;
		try {
			Order order = orderDAO.getById(orderId);
			order.setStatus("Generated");
			orderDAO.update(order);
			baseResponse = new BaseResponse(1, "Order status updated successfully.");
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, "Order status update failure.");
		}
		return baseResponse;
	}

	public BaseResponse cancel(Integer orderId) {
		BaseResponse baseResponse = null;
		try {
			Order order = orderDAO.getById(orderId);
			order.setStatus("Cancelled");
			orderDAO.update(order);
			baseResponse = new BaseResponse(1, "Order status updated successfully.");
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, "Order status update failure.");
		}
		return baseResponse;
	}

	public BaseResponse getStatus(Integer orderId) {
		Order order = orderDAO.getById(orderId);
		BaseResponse baseResponse = null;
		if (order == null) {
			baseResponse = new BaseResponse(0, "No order with given id found.");
		} else {
			baseResponse = new BaseResponse(1, "Order found.");
			baseResponse.addData("orderStatus", order.getStatus());
		}
		return baseResponse;
	}

}
