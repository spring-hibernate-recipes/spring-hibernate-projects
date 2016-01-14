package org.aryalinux.classicmodels.controller;

import org.aryalinux.classicmodels.common.BaseResponse;
import org.aryalinux.classicmodels.common.request.CustomerLoginRequest;
import org.aryalinux.classicmodels.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@ResponseBody
	@RequestMapping(path = "/rest/customer/authenticate", method = RequestMethod.POST)
	public BaseResponse authenticateAndStartSession(@RequestBody CustomerLoginRequest loginRequest) {
		return customerService.authenticateAndStartSession(loginRequest);
	}
}
