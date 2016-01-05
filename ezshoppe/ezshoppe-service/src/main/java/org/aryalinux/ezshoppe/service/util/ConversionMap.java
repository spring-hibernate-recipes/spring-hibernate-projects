package org.aryalinux.ezshoppe.service.util;

import java.util.HashMap;
import java.util.Map;

public class ConversionMap {
	private Map<String, String> map;

	public ConversionMap() {
		map = new HashMap<String, String>();
	}

	public ConversionMap add(String source, String target) {
		map.put(source, target);
		return this;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

}
