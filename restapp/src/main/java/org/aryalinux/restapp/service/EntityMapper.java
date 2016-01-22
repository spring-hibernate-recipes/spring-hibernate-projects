package org.aryalinux.restapp.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.aryalinux.common.EntityList;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class EntityMapper {
	private Map<String, Class> entities;

	public EntityMapper() {
		entities = new LinkedHashMap<String, Class>();
	}

	public Map<String, Class> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, Class> entities) {
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
}
