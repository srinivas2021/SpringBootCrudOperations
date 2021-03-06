package com.hcl.test.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.test.error.CustomException;
import com.hcl.test.model.Employee;
import com.hcl.test.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static final Map<String, Employee> staticDb = new HashMap<>();
	
	static {
		Employee emp = new Employee();
		emp.setEmpId("605218");
		emp.setEmpName("Srinivas");
		emp.setAddress("Hyderabad");
		emp.setPhoneNumber("9000954321");
		staticDb.put(emp.getEmpId(), emp);
	}
	
	@Override
	public void createEmployee(Employee employee) {
		staticDb.put(employee.getEmpId(), employee);
	}

	@Override
	public Employee getEmployeeByEmployeeId(String empId) throws CustomException{
		Employee empResponse = null;
		empResponse = staticDb.get(empId);
		if(empResponse == null){
			throw new CustomException("Employee not found for given id " + empId + "", HttpStatus.NOT_FOUND);
		}
		return empResponse;
	}

}
