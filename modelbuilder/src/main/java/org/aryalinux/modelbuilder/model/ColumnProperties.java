package org.aryalinux.modelbuilder.model;

public class ColumnProperties {
	private String tableColumnName;
	private String propertyName;
	private String dataType;
	private String javaType;
	private int length;
	private boolean primary;
	private boolean joinColumn;
	private int joinType;
	private String fetchType;
	private String cascadeType;

	public String getTableColumnName() {
		return tableColumnName;
	}

	public void setTableColumnName(String tableColumnName) {
		this.tableColumnName = tableColumnName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
		if (dataType.contains("TEXT") || dataType.contains("BLOB")) {
			javaType = "byte[]";
		}
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		if (javaType.equals("12")) {
			javaType = "String";
		} else if (javaType.equals("8")) {
			javaType = "Double";
		} else if (javaType.equals("4")) {
			javaType = "Integer";
		} else if (javaType.equals("5")) {
			javaType = "Short";
		} else if (javaType.equals("-1") || dataType.contains("TEXT") || dataType.contains("BLOB")) {
			javaType = "byte[]";
		} else if (javaType.equals("91")) {
			javaType = "Date";
		} else if (javaType.equals("93")) {
			javaType = "Date";
		} else if (javaType.equals("-7")) {
			javaType = "Boolean";
		}
		this.javaType = javaType;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public boolean isJoinColumn() {
		return joinColumn;
	}

	public void setJoinColumn(boolean joinColumn) {
		this.joinColumn = joinColumn;
	}

	public int getJoinType() {
		return joinType;
	}

	public void setJoinType(int joinType) {
		this.joinType = joinType;
	}

	public String getFetchType() {
		return fetchType;
	}

	public void setFetchType(String fetchType) {
		this.fetchType = fetchType;
	}

	public String getCascadeType() {
		return cascadeType;
	}

	public void setCascadeType(String cascadeType) {
		this.cascadeType = cascadeType;
	}

}