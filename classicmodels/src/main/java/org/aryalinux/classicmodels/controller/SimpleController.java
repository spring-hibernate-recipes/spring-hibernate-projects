package org.aryalinux.classicmodels.controller;

import org.aryalinux.classicmodels.common.BaseResponse;
import org.aryalinux.classicmodels.common.request.SimpleRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
	@ResponseBody
	@RequestMapping(path = "/rest/simple", method = RequestMethod.POST)
	public BaseResponse simple(@RequestBody SimpleRequest simpleRequest) {
		BaseResponse baseResponse = new BaseResponse(1, "Sucsess");
		baseResponse.setData(simpleRequest);
		return baseResponse;
	}
}
