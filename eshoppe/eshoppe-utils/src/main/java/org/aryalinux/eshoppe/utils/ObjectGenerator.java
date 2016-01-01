package org.aryalinux.eshoppe.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ObjectGenerator {
	DataUtil dataUtil;

	public List<Object> createObjects(Class clazz, int count) {
		dataUtil = new DataUtil();
		List<Object> objects = new ArrayList<Object>();
		for (int i = 0; i < count; i++) {
			objects.add(createObject(clazz));
		}
		return objects;
	}

	public Object createObject(Class clazz) {
		try {
			Object ref = clazz.newInstance();
			Method[] methods = clazz.getDeclaredMethods();
			Method[] superClassMethods = clazz.getSuperclass().getDeclaredMethods();
			Method[] allMethods = new Method[methods.length + superClassMethods.length];
			for (int i=0; i<allMethods.length; i++) {
				if (i <methods.length) {
					allMethods[i] = methods[i];
				}
				else {
					allMethods[i] = superClassMethods[i - methods.length];
				}
			}
			for (Method method : allMethods) {
				if (!method.getName().contains("getId")) {
					if (method.getName().startsWith("get")) {
						Class returnType = method.getReturnType();
						String returnTypeName = method.getGenericReturnType().toString();
						String propertyName = method.getName().replace("get", "");
						Method setter = clazz.getMethod("set" + propertyName, returnType);
						if (returnType == Integer.class) {
							setter.invoke(ref, new Random(System.currentTimeMillis()).nextInt());
						} else if (returnType == Double.class) {
							setter.invoke(ref, new Random(System.currentTimeMillis()).nextDouble());
						} else if (returnType == String.class) {
							if (propertyName.equalsIgnoreCase("name")) {
								setter.invoke(ref, dataUtil.getName());
							} else if (propertyName.contains("email") || propertyName.contains("Email")
									&& !(propertyName.contains("Address") || propertyName.contains("address"))) {
								setter.invoke(ref, dataUtil.getEmail());
							} else if (propertyName.contains("phone") || propertyName.contains("Phone")) {
								setter.invoke(ref, dataUtil.getPhoneNumber());
							} else if (propertyName.contains("Address") || propertyName.contains("address")) {
								setter.invoke(ref, dataUtil.getAddress());
							} else if (propertyName.contains("city") || propertyName.contains("City")) {
								setter.invoke(ref, dataUtil.getString(15, 20));
							} else if (propertyName.contains("city") || propertyName.contains("State")) {
								setter.invoke(ref, dataUtil.getString(12, 15));
							} else if (propertyName.contains("zip") || propertyName.contains("Zip")
									|| propertyName.contains("pin") || propertyName.contains("Pin")) {
								setter.invoke(ref, dataUtil.getNumber(6));
							} else if (propertyName.contains("description") || propertyName.contains("Description")) {
								setter.invoke(ref, dataUtil.camel(dataUtil.getLine()));
							}
						} else if (returnType == Date.class) {
							setter.invoke(ref, new Date());
						} else if (returnType == Set.class || returnType == List.class) {
							String[] parts = returnTypeName.replace("<", " ").replace(">", "").split(" ");
							String className = parts[0];
							String generic = parts[1];
							Object x = null;
							if (generic.equals("java.lang.String") && className.equals("java.util.Set")) {
								HashSet<String> stringSet = new HashSet<String>();
								x = stringSet;
								for (int i = 0; i < new Random().nextInt(10); i++) {
									stringSet.add(dataUtil.getString(5, 20));
								}
							} else if (generic.equals("java.lang.String") && className.equals("java.util.List")) {
								ArrayList<String> stringList = new ArrayList<String>();
								x = stringList;
								for (int i = 0; i < new Random().nextInt(10); i++) {
									stringList.add(dataUtil.getString(5, 20));
								}
							} else if (generic.equals("java.lang.Integer") && className.equals("java.util.Set")) {
								HashSet<Integer> intSet = new HashSet<Integer>();
								x = intSet;
								for (int i = 0; i < new Random().nextInt(10); i++) {
									intSet.add(Integer.parseInt(dataUtil.getNumber(2)));
								}
							} else if (generic.equals("java.lang.Integer") && className.equals("java.util.List")) {
								ArrayList<Integer> intList = new ArrayList<Integer>();
								x = intList;
								for (int i = 0; i < new Random().nextInt(10); i++) {
									intList.add(Integer.parseInt(dataUtil.getNumber(2)));
								}
							}
							setter.invoke(ref, x);
						}
					}
				}
			}
			return ref;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
