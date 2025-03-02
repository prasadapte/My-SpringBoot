package com.practice.practice.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import com.practice.practice.Model.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(Long id);
	ResponseEntity<Employee> updateEmployee(Long id,Employee employee);
	Employee updateEmployee2(Long id,Employee employee);
	void deleteEmployee(Long id);
	Page<Employee> getPageData(PageRequest page);
	List<Employee> getByDepartment(String department);
}
