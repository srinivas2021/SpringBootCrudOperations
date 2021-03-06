package com.hcl.test.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.test.error.CustomException;
import com.hcl.test.model.Employee;
import com.hcl.test.service.EmployeeService;
import com.hcl.test.validationUtil.EmployeeRequestValidationUtil;

@RestController
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	EmployeeRequestValidationUtil validationUtil;
	
    @GetMapping(value = "/employee/getEmployee/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable String id) throws CustomException{
		
    	validationUtil.validateEmployeeId(new Long(id));
    	Employee response = null;
		response = employeeService.getEmployeeByEmployeeId(id);
		logger.info("Fetched  employee is {}", id);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
    
    @PostMapping("/employee/create")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
    	employeeService.createEmployee(employee);
    	logger.info("New employee created");
		return new ResponseEntity<Object>(employee, HttpStatus.OK);
    }

}
