package org.aryalinux.eshoppe.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "assets")
public class Asset extends BaseEntity {
	@Column
	private String assetIdentification;
	@Column
	private String type;
	@Column
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee owner;
	@Column
	private Double price;
	@Temporal(TemporalType.DATE)
	private Date procuredOn;
	@OneToOne(fetch = FetchType.LAZY)
	private Employee procuredBy;

	public String getAssetIdentification() {
		return assetIdentification;
	}

	public void setAssetIdentification(String assetIdentification) {
		this.assetIdentification = assetIdentification;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getProcuredOn() {
		return procuredOn;
	}

	public void setProcuredOn(Date procuredOn) {
		this.procuredOn = procuredOn;
	}

	public Employee getProcuredBy() {
		return procuredBy;
	}

	public void setProcuredBy(Employee procuredBy) {
		this.procuredBy = procuredBy;
	}

}
