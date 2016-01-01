package org.aryalinux.eshoppe.utils;

import java.util.Map;
import java.util.Map.Entry;

public class DataUtil {
	public static Object generateObject(Map<String, Map<String, Object>> dataDescriptor, Class clazz) {
		for (Entry<String, Map<String, Object>> entry : dataDescriptor.entrySet()) {
			String property = entry.getKey();
			Map<String, Object> dataMap = entry.getValue();
			if (dataMap.get("name").equals("firstName")) {
				
			}
		}
		return null;
	}
}
