package org.aryalinux.eshoppe.data.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
	@Column
	private String employeeCode;
	@Column
	private String adId;
	@Column
	private String companyEmailAddress;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String emailAddress;
	@Column
	private String password;
	@Column
	private String emergencyContactName;
	@Column
	private String emergencyContactNumber;
	@Column
	private String status;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private SalaryStructure currentSalaryStructure;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Role presentRole;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private Address address;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private EmployeeSeating seating;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Asset> assets;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Promotion> promotions;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Appraisal> appraisals;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private List<EducationalQualification> educationalQualifications;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private List<WorkExperience> workExperiences;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Employee manager;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Employee hrManager;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Payout> payouts;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SalaryStructure getCurrentSalary() {
		return currentSalaryStructure;
	}

	public void setCurrentSalary(SalaryStructure currentSalary) {
		this.currentSalaryStructure = currentSalary;
	}

	public Role getPresentRole() {
		return presentRole;
	}

	public void setPresentRole(Role presentRole) {
		this.presentRole = presentRole;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getCompanyEmailAddress() {
		return companyEmailAddress;
	}

	public void setCompanyEmailAddress(String companyEmailAddress) {
		this.companyEmailAddress = companyEmailAddress;
	}

	public EmployeeSeating getSeating() {
		return seating;
	}

	public void setSeating(EmployeeSeating seating) {
		this.seating = seating;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	public SalaryStructure getCurrentSalaryStructure() {
		return currentSalaryStructure;
	}

	public void setCurrentSalaryStructure(SalaryStructure currentSalaryStructure) {
		this.currentSalaryStructure = currentSalaryStructure;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public List<Appraisal> getAppraisals() {
		return appraisals;
	}

	public void setAppraisals(List<Appraisal> appraisals) {
		this.appraisals = appraisals;
	}

	public List<EducationalQualification> getEducationalQualifications() {
		return educationalQualifications;
	}

	public void setEducationalQualifications(List<EducationalQualification> educationalQualifications) {
		this.educationalQualifications = educationalQualifications;
	}

	public List<WorkExperience> getWorkExperiences() {
		return workExperiences;
	}

	public void setWorkExperiences(List<WorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Employee getHrManager() {
		return hrManager;
	}

	public void setHrManager(Employee hrManager) {
		this.hrManager = hrManager;
	}

	public List<Payout> getPayouts() {
		return payouts;
	}

	public void setPayouts(List<Payout> payouts) {
		this.payouts = payouts;
	}

}
