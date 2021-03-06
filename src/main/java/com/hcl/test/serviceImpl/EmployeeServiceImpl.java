package com.hcl.test.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.test.error.CustomException;
import com.hcl.test.model.Employee;
import com.hcl.test.repository.EmployeeRespository;
import com.hcl.test.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRespository employeeRespository;

	@Override
	public void createEmployee(Employee employee) {
		employeeRespository.save(employee);
	}

	@Override
	public Employee getEmployeeByEmployeeId(String empId) throws CustomException {
		Optional<Employee> empResponse;

		empResponse = employeeRespository.findById(empId);
		if (ObjectUtils.isEmpty(empResponse)) {
			throw new CustomException("Employee not found for given id " + empId + "", HttpStatus.NOT_FOUND);
		}

		return empResponse.get();
	}

}
