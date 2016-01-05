package org.aryalinux.ezshoppe.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aryalinux.ezshoppe.commons.request.NewCustomerRequest;
import org.aryalinux.ezshoppe.commons.response.BaseResponse;
import org.aryalinux.ezshoppe.dao.CustomerDAO;
import org.aryalinux.ezshoppe.model.Customer;
import org.aryalinux.ezshoppe.service.CustomerService;
import org.aryalinux.ezshoppe.service.util.ConversionMap;
import org.aryalinux.ezshoppe.service.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	public BaseResponse newCustomer(NewCustomerRequest newCustomerRequest) {
		Customer customer = (Customer) ObjectUtil.convert(newCustomerRequest, Customer.class,
				new ConversionMap().add("firstName", "firstName").add("lastName", "lastName")
						.add("emailAddress", "emailAddress").add("password", "password").add("address", "address")
						.add("phone", "phone"));
		Integer id = customerDAO.create(customer);
		BaseResponse response = new BaseResponse(1, "Customer Created Successfully");
		response.addData("customerId", id);
		return response;
	}

	public BaseResponse getCustomerDetails(Integer id) {
		Customer customer = customerDAO.getById(id);
		BaseResponse baseResponse = null;
		if (customer != null) {
			baseResponse = new BaseResponse(1, "Customer found");
			baseResponse.setData(ObjectUtil.convert(customer));
			return baseResponse;
		} else {
			baseResponse = new BaseResponse(0, "Customer not found");
			return baseResponse;
		}
	}

	public BaseResponse getCustomerDetailsByEmailAddress(String emailAddress) {
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("emailAddress", emailAddress);
		List<Customer> customers = customerDAO.getByCriteria(criteria);
		BaseResponse baseResponse = null;
		if (customers != null && customers.size() > 1) {
			baseResponse = new BaseResponse(0, "Multiple customer entries found for email address");
		} else if (customers == null) {
			baseResponse = new BaseResponse(0, "No customer entries found for email address");
		} else if (customers != null && customers.size() == 1) {
			baseResponse = new BaseResponse(1, "Customer found");
			baseResponse.setData(ObjectUtil.convert(customers.get(0)));
		}
		return baseResponse;
	}

	public BaseResponse updateAddress(Integer customerId, String newAddress) {
		Customer customer = customerDAO.getById(customerId);
		BaseResponse baseResponse = null;
		if (customer != null) {
			customer.setAddress(newAddress);
			customerDAO.update(customer);
			baseResponse = new BaseResponse(1, "Address updated");
		} else if (customer == null) {
			baseResponse = new BaseResponse(0, "No customer entry found for id");
		}
		return baseResponse;
	}

	public BaseResponse updatePhone(Integer customerId, String phone) {
		Customer customer = customerDAO.getById(customerId);
		BaseResponse baseResponse = null;
		if (customer != null) {
			customer.setPhone(phone);
			customerDAO.update(customer);
			baseResponse = new BaseResponse(1, "Phone number updated");
		} else if (customer == null) {
			baseResponse = new BaseResponse(0, "No customer entry found for id");
		}
		return baseResponse;
	}

	public BaseResponse updateEmailAddress(Integer customerId, String emailAddress) {
		Customer customer = customerDAO.getById(customerId);
		BaseResponse baseResponse = null;
		if (customer != null) {
			customer.setEmailAddress(emailAddress);
			customerDAO.update(customer);
			baseResponse = new BaseResponse(1, "Phone number updated");
		} else if (customer == null) {
			baseResponse = new BaseResponse(0, "No customer entry found for id");
		}
		return baseResponse;
	}

	public BaseResponse authenticate(String emailAddress, String password) {
		Map<String, Object> criteria = new HashMap<String, Object>();
		criteria.put("emailAddress", emailAddress);
		criteria.put("password", password);
		List<Customer> customers = customerDAO.getByCriteria(criteria);
		BaseResponse baseResponse = null;
		if (customers != null && customers.size() > 1) {
			baseResponse = new BaseResponse(0,
					"Multiple customer entries found for email address and password. Something is wrong.");
		} else if (customers == null) {
			baseResponse = new BaseResponse(0, "Authentication Failure.");
		} else if (customers != null && customers.size() == 1) {
			baseResponse = new BaseResponse(1, "Authentication Success.");
			baseResponse.setData(ObjectUtil.convert(customers.get(0)));
		}
		return baseResponse;
	}

}
