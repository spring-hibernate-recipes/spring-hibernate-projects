package org.aryalinux.modelbuilder.model;

public class ColumnProperties {
	private String name;
	private String dataType;
	private String javaType;
	private int length;
	private boolean primary;
	private boolean joinColumn;
	private int joinType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
