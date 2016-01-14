package org.aryalinux.classicmodels.service;

import org.aryalinux.classicmodels.common.BaseResponse;
import org.aryalinux.classicmodels.common.request.CustomerLoginRequest;

public interface CustomerService {
	BaseResponse authenticateAndStartSession(CustomerLoginRequest loginRequest);

	BaseResponse endSession();
}
