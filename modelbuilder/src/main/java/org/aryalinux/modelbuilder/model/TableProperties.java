package org.aryalinux.modelbuilder.model;

import java.util.List;

public class TableProperties {
	private String name;
	private List<ColumnProperties> columnProperties;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ColumnProperties> getColumnProperties() {
		return columnProperties;
	}

	public void setColumnProperties(List<ColumnProperties> columnProperties) {
		this.columnProperties = columnProperties;
	}

}
