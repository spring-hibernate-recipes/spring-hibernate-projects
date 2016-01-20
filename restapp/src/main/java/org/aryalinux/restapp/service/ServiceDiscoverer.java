package org.aryalinux.restapp.service;

import java.util.Map;

public class ServiceDiscoverer {
	private Map<String, GenericService> services;

	public Map<String, GenericService> getServices() {
		return services;
	}

	public void setServices(Map<String, GenericService> services) {
		this.services = services;
	}

	public GenericService getServiceByName(String name) {
		return services.get(name);
	}
}
