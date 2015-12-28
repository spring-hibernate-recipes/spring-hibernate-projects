package org.aryalinux.eshoppe.data.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Appraisal extends BaseEntity {
	@Temporal(TemporalType.DATE)
	private Date appraisalDate;
	@OneToOne
	private Employee employee;
	@OneToOne
	private Employee reviewer;
	@OneToMany
	private List<AppraisalMetric> appraisalMetrics;
	@Column
	private String result;

	public Date getAppraisalDate() {
		return appraisalDate;
	}

	public void setAppraisalDate(Date appraisalDate) {
		this.appraisalDate = appraisalDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getReviewer() {
		return reviewer;
	}

	public void setReviewer(Employee reviewer) {
		this.reviewer = reviewer;
	}

	public List<AppraisalMetric> getAppraisalMetrics() {
		return appraisalMetrics;
	}

	public void setAppraisalMetrics(List<AppraisalMetric> appraisalMetrics) {
		this.appraisalMetrics = appraisalMetrics;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
