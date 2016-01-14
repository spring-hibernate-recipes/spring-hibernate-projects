package org.aryalinux.classicmodels.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.aryalinux.classicmodels.common.BaseResponse;
import org.aryalinux.classicmodels.common.request.CustomerLoginRequest;
import org.aryalinux.classicmodels.dao.CustomerDAO;
import org.aryalinux.classicmodels.model.Customer;
import org.aryalinux.classicmodels.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	public BaseResponse authenticateAndStartSession(CustomerLoginRequest loginRequest) {
		BaseResponse baseResponse = null;
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("customerNumber", loginRequest.getCustomerNumber());
		params.put("postalCode", loginRequest.getPostalCode());
		try {
			List<Customer> customers = customerDAO.getByParams(params);
			if (customers != null && customers.size() > 0) {
				Customer customer = customers.get(0);
				baseResponse = new BaseResponse(1, "Welcome " + customer.getCustomerName());
				baseResponse.setData(customer);
			} else {
				baseResponse = new BaseResponse(0, "Authentication Failure.");
			}
		} catch (Exception ex) {
			baseResponse = new BaseResponse(0, "Authentication Failure. Some error occured.");
			baseResponse.setData(ex);
		}
		return baseResponse;
	}

	public BaseResponse endSession() {
		// TODO Auto-generated method stub
		return null;
	}

}
