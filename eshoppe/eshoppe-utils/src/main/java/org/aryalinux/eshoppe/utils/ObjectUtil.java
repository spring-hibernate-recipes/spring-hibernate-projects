package org.aryalinux.eshoppe.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object transferState(Object source, Class destinationType) {
		Class clazz = source.getClass();
		Method[] methods = destinationType.getMethods();
		Object returnValue;
		try {
			returnValue = destinationType.newInstance();
		} catch (InstantiationException e1) {
			throw new RuntimeException("Cannot create an instance of " + destinationType);
		} catch (IllegalAccessException e1) {
			throw new RuntimeException("Cannot call constructor of " + destinationType);
		}
		for (Method method : methods) {
			if (method.getName().startsWith("set")) {
				String propertyName = method.getName().replace("set", "");
				// propertyName = Character.toLowerCase(propertyName.charAt(0))
				// + propertyName.substring(1);
				String getter = "get" + propertyName;
				try {
					Method getterMethod = clazz.getMethod(getter);
					Object getterValue = getterMethod.invoke(source);
					method.invoke(returnValue, getterValue);
				} catch (NoSuchMethodException e) {
					System.out.println("Method : " + getter + " not found on source.");
				} catch (SecurityException e) {
					throw new RuntimeException(
							"Method : " + getter + " not callable on source due to security constraints.");
				} catch (IllegalAccessException e) {
					throw new RuntimeException(
							"Method : " + method.getName() + " not callable on destination due to access constraints.");
				} catch (IllegalArgumentException e) {
					throw new RuntimeException(
							"Method : " + method.getName() + " not callable on destination. Wrong arguments.");
				} catch (InvocationTargetException e) {
					throw new RuntimeException("Method : " + method.getName() + " threw exception.");
				}
			}
		}
		return returnValue;
	}
}
