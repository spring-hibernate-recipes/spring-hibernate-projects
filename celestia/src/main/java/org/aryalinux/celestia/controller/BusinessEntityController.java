package org.aryalinux.celestia.controller;

import org.aryalinux.celestia.commons.response.BaseResponse;
import org.aryalinux.celestia.service.BusinessEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BusinessEntityController {
	@Autowired
	private BusinessEntityService entityService;

	@RequestMapping(path = "/rest/entity", method = RequestMethod.POST)
	public BaseResponse createNewEntity(String name, String description) {
		return null;
	}
}
