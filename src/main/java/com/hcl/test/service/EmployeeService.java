package com.hcl.test.service;

import com.hcl.test.error.CustomException;
import com.hcl.test.model.Employee;

public interface EmployeeService {

	public void createEmployee(Employee employee);
	
	public Employee getEmployeeByEmployeeId(String empId) throws CustomException;
}
