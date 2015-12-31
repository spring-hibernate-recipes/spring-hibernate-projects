package org.aryalinux.eshoppe.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ConversionMap {
	private Map<String, String> map;

	public ConversionMap() {
		map = new LinkedHashMap<String, String>();
	}

	public ConversionMap add(String key, String value) {
		map.put(key, value);
		return this;
	}

	public Set<Entry<String, String>> entrySet() {
		return map.entrySet();
	}
}
