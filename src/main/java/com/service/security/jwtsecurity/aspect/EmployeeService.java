package com.service.security.jwtsecurity.aspect;

import org.springframework.stereotype.Service;

import com.service.security.jwtsecurity.constraint.Roles;
import com.service.security.jwtsecurity.model.Employee;

@Service
public class EmployeeService {
	@Roles(value = {"user"})
	public Employee createEmployee(String name, String empId,String[] ls) {

		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmpId(empId);
		return emp;
	}

	public void deleteEmployee(String empId) {
		
	}
}