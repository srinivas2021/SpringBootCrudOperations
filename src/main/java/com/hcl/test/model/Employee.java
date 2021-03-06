package com.hcl.test.model;

import javax.validation.constraints.NotEmpty;

public class Employee {

	private String empId;
	
	@NotEmpty(message = "employee name must not be empty")
	private String empName;
	
	private String address;
	
	@NotEmpty(message = "phone number must not be empty")
	private String phoneNumber;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
}
