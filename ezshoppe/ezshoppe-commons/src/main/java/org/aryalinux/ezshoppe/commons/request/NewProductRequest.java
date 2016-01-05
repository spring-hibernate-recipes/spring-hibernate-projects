package org.aryalinux.ezshoppe.commons.request;

import java.util.HashMap;
import java.util.Map;

public class NewProductRequest {
	private String productCode;
	private String name;
	private String description;
	private Map<String, String> properties;
	private double markedPrice;
	private double salePrice;
	private int presentStock;
	private int threshold;
	private int categoryId;

	public NewProductRequest() {
		properties = new HashMap<String, String>();
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

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

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public double getMarkedPrice() {
		return markedPrice;
	}

	public void setMarkedPrice(double markedPrice) {
		this.markedPrice = markedPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public int getPresentStock() {
		return presentStock;
	}

	public void setPresentStock(int presentStock) {
		this.presentStock = presentStock;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
