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
@Table(name = "educationalQualifications")
public class EducationalQualification extends BaseEntity {
	@Column
	private String education;
	@Column
	private String institution;
	@Column
	private String organization;
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	private Date toDate;
	@Column
	private Double percentage;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
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

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
