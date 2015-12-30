package org.aryalinux.eshoppe.data.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Appraisal extends BaseEntity {
	@Temporal(TemporalType.DATE)
	private Date appraisalDate;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee reviewer;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "appraisal")
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
