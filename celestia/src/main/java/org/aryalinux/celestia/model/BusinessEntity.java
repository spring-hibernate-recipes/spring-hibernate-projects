package org.aryalinux.celestia.model;

import java.util.List;

public class BusinessEntity extends BaseEntity {
	private String name;
	private String description;
	private List<EntityProperty> properties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EntityProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<EntityProperty> properties) {
		this.properties = properties;
	}

}
