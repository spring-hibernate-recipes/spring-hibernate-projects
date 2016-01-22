package org.aryalinux.restapp.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.aryalinux.common.EntityList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityConverter {
	private Map<String, String> entities;

	public EntityConverter() {
		entities = new LinkedHashMap<String, String>();
	}

	public Map<String, String> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, String> entities) {
		this.entities = entities;
	}

	public Object convert(Map<String, Object> data, String objectId) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			Object pojo = mapper.convertValue(data, Class.forName(entities.get(objectId)));
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
}
