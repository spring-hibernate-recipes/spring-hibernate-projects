package org.aryalinux.ezshoppe.service;

import org.aryalinux.restapptemplate.service.ServiceDiscovery;
import org.aryalinux.restapptemplate.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocalServiceDiscovery extends ServiceDiscovery {
	@Autowired
	private ProductCategoryService productCategoryService;

	@SuppressWarnings("rawtypes")
	public GenericServiceImpl getServiceByName(String name) {
		if (name.equals("category")) {
			return productCategoryService;
		}
		return null;
	}
}
