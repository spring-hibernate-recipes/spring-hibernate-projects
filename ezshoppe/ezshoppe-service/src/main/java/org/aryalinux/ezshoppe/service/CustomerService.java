package org.aryalinux.ezshoppe.service;

import org.aryalinux.ezshoppe.commons.request.NewCustomerRequest;
import org.aryalinux.ezshoppe.commons.response.BaseResponse;

public interface CustomerService {
	BaseResponse newCustomer(NewCustomerRequest newCustomerRequest);

	BaseResponse getCustomerDetails(Integer id);

	BaseResponse getCustomerDetailsByEmailAddress(String emailAddress);

	BaseResponse updateAddress(Integer customerId, String newAddress);

	BaseResponse updatePhone(Integer customerId, String phone);

	BaseResponse updateEmailAddress(Integer customerId, String emailAddress);

	BaseResponse authenticate(String emailAddress, String password);
}
