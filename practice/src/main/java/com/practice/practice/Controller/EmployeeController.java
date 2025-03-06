package com.practice.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.practice.Model.Employee;
import com.practice.practice.Service.EmployeeService;


@RestController()
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping()	
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}
	

	@PutMapping("/2/{id}")
	public Employee updateEmployee2(@PathVariable Long id,@RequestBody Employee employee) {
		return employeeService.updateEmployee2(id, employee);
	}
	
	@GetMapping()
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	
	@GetMapping("/page/{page}/{size}/{field}")
	public Page<Employee> getPageData(@PathVariable int page,@PathVariable int size,@PathVariable String field){
		return employeeService.getPageData(PageRequest.of(page, size,Sort.by(field)));
	}
	
	@GetMapping("/getByDepartment/{department}")
	public List<Employee> fetchByDepartment(@PathVariable String department){
		return employeeService.getByDepartment(department);
	}
	
	
	
	
	
	
}
