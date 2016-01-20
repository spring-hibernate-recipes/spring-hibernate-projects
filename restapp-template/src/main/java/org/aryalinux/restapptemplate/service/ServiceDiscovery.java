package org.aryalinux.restapptemplate.service;

import org.aryalinux.restapptemplate.service.impl.GenericServiceImpl;

public abstract class ServiceDiscovery {
	public abstract GenericServiceImpl getServiceByName(String name);
}
