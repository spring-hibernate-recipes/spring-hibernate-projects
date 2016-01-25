package org.aryalinux.restapp.model;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("rawtypes")
public final class Reflector {
	public static class EntityField {
		private String name;
		private String type;
		private String generic;

		public EntityField(String name, String type, String generic) {
			this.name = name;
			this.type = type;
			this.generic = generic;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getGeneric() {
			return generic;
		}

		public void setGeneric(String generic) {
			this.generic = generic;
		}

		public String toString() {
			return "{\"name\": \"" + name + "\", \"type\": \"" + type + "\", \"description\": \"" + generic + "\"}";
		}
	}

	public static List<EntityField> getStructure(Class clazz) {
		try {
			List<EntityField> result = new LinkedList<EntityField>();
			Method[] setters = clazz.getDeclaredMethods();
			for (Method method : setters) {
				if (method.getName().startsWith("set")) {
					Class paramType = method.getParameterTypes()[0];
					if (paramType.equals(List.class) || paramType.equals(Set.class)) {
						Type[] genericParameterTypes = method.getGenericParameterTypes();
						Type type = genericParameterTypes[0];
						if (type instanceof ParameterizedType) {
							ParameterizedType aType = (ParameterizedType) type;
							Type[] parameterArgTypes = aType.getActualTypeArguments();
							for (Type parameterArgType : parameterArgTypes) {
								Class parameterArgClass = (Class) parameterArgType;
								result.add(new EntityField(method.getName().replace("set", ""), "aggregate",
										parameterArgClass.getName()));
							}
						}
					} else {
						if (paramType.equals(String.class) || paramType.equals(Integer.class)
								|| paramType.equals(Double.class) || paramType.equals(Date.class)) {
							result.add(
									new EntityField(method.getName().replace("set", ""), "field", paramType.getName()));
						} else {
							result.add(new EntityField(method.getName().replace("set", ""), "reference",
									paramType.getName()));
						}
					}
				}

			}
			return result;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}
}
