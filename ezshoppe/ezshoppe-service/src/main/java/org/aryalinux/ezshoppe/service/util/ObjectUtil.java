package org.aryalinux.ezshoppe.service.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectUtil {
	public static Object convert(Object ref) {
		ObjectMapper objectMapper = new ObjectMapper();
		if (ref instanceof List) {
			return objectMapper.convertValue(ref, ArrayList.class);
		} else {
			return objectMapper.convertValue(ref, Map.class);
		}
	}

	@SuppressWarnings("rawtypes")
	public static Object convert(Object source, Class dest, ConversionMap conversionMap) {
		Map<String, String> map = conversionMap.getMap();
		try {
			Object result = dest.newInstance();
			for (Entry<String, String> entry : map.entrySet()) {
				Method getter = source.getClass().getMethod(getter(entry.getKey()));
				Method setter = result.getClass().getMethod(setter(entry.getKey()), getter.getReturnType());
				Object value = getter.invoke(source);
				setter.invoke(result, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}

	private static String setter(String propertyName) {
		return "set" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
	}

	private static String getter(String propertyName) {
		return "get" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
	}
}
