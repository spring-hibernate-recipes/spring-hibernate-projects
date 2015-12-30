package org.aryalinux.eshoppe.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employeeSeating")
public class EmployeeSeating extends BaseEntity {
	@Column
	private String building;
	@Column
	private String floor;
	@Column
	private String wing;
	@Column
	private String desk;
	@Column
	private String deskPhoneNumber;
	@OneToOne(fetch = FetchType.LAZY)
	private Employee employee;

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getWing() {
		return wing;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}

	public String getDesk() {
		return desk;
	}

	public void setDesk(String desk) {
		this.desk = desk;
	}

	public String getDeskPhoneNumber() {
		return deskPhoneNumber;
	}

	public void setDeskPhoneNumber(String deskPhoneNumber) {
		this.deskPhoneNumber = deskPhoneNumber;
	}

}
