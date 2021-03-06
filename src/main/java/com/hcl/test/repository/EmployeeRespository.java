package com.hcl.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hcl.test.model.Employee;

@Repository
public interface EmployeeRespository extends MongoRepository<Employee, String> {

}
