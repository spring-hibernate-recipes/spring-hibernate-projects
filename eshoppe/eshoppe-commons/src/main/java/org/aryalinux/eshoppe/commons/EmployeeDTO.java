package org.aryalinux.eshoppe.commons;

public class EmployeeDTO extends BaseDTO {
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private SalaryDTO salary;
	private RoleDTO role;
	private AddressDTO address;

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

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public SalaryDTO getSalary() {
		return salary;
	}

	public void setSalary(SalaryDTO salary) {
		this.salary = salary;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

}
