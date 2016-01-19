package org.aryalinux.celestia.model;

public class EntityProperty {
	private String name;
	private String formLabel;
	private String databaseType;
	private String modelClassType;
	private boolean isCollection;
	private String collectionClassName;
	private boolean isReference;
	private String referenceClassName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormLabel() {
		return formLabel;
	}

	public void setFormLabel(String formLabel) {
		this.formLabel = formLabel;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	public String getModelClassType() {
		return modelClassType;
	}

	public void setModelClassType(String modelClassType) {
		this.modelClassType = modelClassType;
	}

	public boolean isCollection() {
		return isCollection;
	}

	public void setCollection(boolean isCollection) {
		this.isCollection = isCollection;
	}

	public String getCollectionClassName() {
		return collectionClassName;
	}

	public void setCollectionClassName(String collectionClassName) {
		this.collectionClassName = collectionClassName;
	}

	public boolean isReference() {
		return isReference;
	}

	public void setReference(boolean isReference) {
		this.isReference = isReference;
	}

	public String getReferenceClassName() {
		return referenceClassName;
	}

	public void setReferenceClassName(String referenceClassName) {
		this.referenceClassName = referenceClassName;
	}

}