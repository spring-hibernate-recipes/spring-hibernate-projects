package org.aryalinux.restapp.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import org.aryalinux.restapp.common.EntityList;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class EntityMapper {
	private LinkedHashMap<String, Class> entities;

	public EntityMapper() {
		entities = new LinkedHashMap<String, Class>();
	}

	public LinkedHashMap<String, Class> getEntities() {
		return entities;
	}

	public void setEntities(LinkedHashMap<String, Class> entities) {
		this.entities = entities;
	}

	public Object convert(Map<String, Object> data, String name) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			Object pojo = mapper.convertValue(data, entities.get(name));
			return pojo;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public EntityList convert(Map<String, Object> data) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			EntityList pojo = (EntityList) mapper.convertValue(data, EntityList.class);
			List<Object> newEntities = new ArrayList<Object>();
			for (Object obj : pojo.getEntities()) {
				Map<String, Object> map = (Map<String, Object>) obj;
				String typeName = map.get("__object_id").toString();
				map.remove("__object_id");
				Object entity = mapper.convertValue(map, entities.get(typeName));
				newEntities.add(entity);
			}
			pojo.setEntities(newEntities);
			return pojo;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public Class getClassForName(String name) {
		try {
			return entities.get(name);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public Class getPrimaryKeyTypeForName(String name) {
		try {
			Class pkClazz = null;
			Class clazz = getClassForName(name);
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				Annotation[] annotations = field.getDeclaredAnnotations();
				for (Annotation annotation: annotations) {
					if (annotation.annotationType() == Id.class) {
						pkClazz = field.getType();
					}
				}
			}
			return pkClazz;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
