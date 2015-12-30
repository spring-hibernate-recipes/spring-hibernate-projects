package org.aryalinux.eshoppe.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AppraisalMetric {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String description;
	@Column
	private Double total;
	@Column
	private Double managerScore;
	@Column
	private Double selfScore;
	@Column
	private String remarks;
	@Column
	private String managerRemarks;
	@ManyToOne(fetch = FetchType.LAZY)
	private Appraisal appraisal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getManagerScore() {
		return managerScore;
	}

	public void setManagerScore(Double managerScore) {
		this.managerScore = managerScore;
	}

	public Double getSelfScore() {
		return selfScore;
	}

	public void setSelfScore(Double selfScore) {
		this.selfScore = selfScore;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getManagerRemarks() {
		return managerRemarks;
	}

	public void setManagerRemarks(String managerRemarks) {
		this.managerRemarks = managerRemarks;
	}

	public Appraisal getAppraisal() {
		return appraisal;
	}

	public void setAppraisal(Appraisal appraisal) {
		this.appraisal = appraisal;
	}

}
