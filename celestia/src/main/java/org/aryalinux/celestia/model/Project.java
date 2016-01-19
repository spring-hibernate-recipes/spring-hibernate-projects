package org.aryalinux.celestia.model;

import java.util.List;

public class Project extends BaseEntity {
	private String name;
	private List<BusinessEntity> businessEntities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BusinessEntity> getBusinessEntities() {
		return businessEntities;
	}

	public void setBusinessEntities(List<BusinessEntity> businessEntities) {
		this.businessEntities = businessEntities;
	}

}
