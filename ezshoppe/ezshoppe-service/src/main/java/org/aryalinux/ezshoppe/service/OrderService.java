package org.aryalinux.ezshoppe.service;

import org.aryalinux.ezshoppe.commons.request.NewOrderRequest;
import org.aryalinux.ezshoppe.commons.response.BaseResponse;

public interface OrderService {
	BaseResponse newOrder(NewOrderRequest newOrderRequest);

	BaseResponse addItem(Integer orderId, Integer productId, Integer quantity, String type, String description);

	BaseResponse removeItem(Integer orderId, Integer itemId);

	BaseResponse checkout(Integer orderId);

	BaseResponse cancel(Integer orderId);

	BaseResponse getStatus(Integer orderId);
}
