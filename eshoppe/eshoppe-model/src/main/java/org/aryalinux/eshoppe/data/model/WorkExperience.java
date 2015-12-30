package org.aryalinux.eshoppe.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "workExperiences")
public class WorkExperience extends BaseEntity {
	@Column
	private String organization;
	@Column
	private String typeOfEngagement;
	@Column
	private String designation;
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	private Date toDate;
	@Column
	private Double ctc;
	@Column
	private String supervisorName;
	@Column
	private String supervisorDesignation;
	@Column
	private String supervisorPhone;
	@Column
	private String hrName;
	@Column
	private String hrDesignation;
	@Column
	private String hrPhone;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getTypeOfEngagement() {
		return typeOfEngagement;
	}

	public void setTypeOfEngagement(String typeOfEngagement) {
		this.typeOfEngagement = typeOfEngagement;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getFrom() {
		return fromDate;
	}

	public void setFrom(Date from) {
		this.fromDate = from;
	}

	public Date getTo() {
		return toDate;
	}

	public void setTo(Date to) {
		this.toDate = to;
	}

	public Double getCtc() {
		return ctc;
	}

	public void setCtc(Double ctc) {
		this.ctc = ctc;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getSupervisorDesignation() {
		return supervisorDesignation;
	}

	public void setSupervisorDesignation(String supervisorDesignation) {
		this.supervisorDesignation = supervisorDesignation;
	}

	public String getSupervisorPhone() {
		return supervisorPhone;
	}

	public void setSupervisorPhone(String supervisorPhone) {
		this.supervisorPhone = supervisorPhone;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getHrDesignation() {
		return hrDesignation;
	}

	public void setHrDesignation(String hrDesignation) {
		this.hrDesignation = hrDesignation;
	}

	public String getHrPhone() {
		return hrPhone;
	}

	public void setHrPhone(String hrPhone) {
		this.hrPhone = hrPhone;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
