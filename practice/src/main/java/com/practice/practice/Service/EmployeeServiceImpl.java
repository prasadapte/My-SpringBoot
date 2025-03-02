package com.practice.practice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.practice.Model.Employee;
import com.practice.practice.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Long id, Employee employee) {
		// TODO Auto-generated method stub
		Employee u = employeeRepository.findById(id).orElse(null);
		if(employeeRepository.existsById(id)) {
			u.setEmail(employee.getEmail());
			u.setName(employee.getName());
			u.setDepartment(employee.getDepartment());
			return new ResponseEntity<>(employeeRepository.save(u),HttpStatus.OK);
//			return employeeRepository.save(u);
		}
		return  new ResponseEntity<>(u,HttpStatus.ACCEPTED);		
//		return null;
	}

	@Override
	public Employee updateEmployee2(Long id, Employee employee) {
		// TODO Auto-generated method stub
		Employee u = employeeRepository.findById(id).orElse(null);
		if(employeeRepository.existsById(id)) {
			u.setEmail(employee.getEmail());
			u.setName(employee.getName());
			u.setDepartment(employee.getDepartment());
//			return new ResponseEntity<>(employeeRepository.save(u),HttpStatus.OK);
			return employeeRepository.save(u);
		}
//		return  new ResponseEntity<>(u,HttpStatus.ACCEPTED);		
		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> e = employeeRepository.findById(id);
		if(e.isPresent())
			employeeRepository.deleteById(id);
		else
			throw new RuntimeException("Id Not Found");
	}
	
	
	public Page<Employee> getPageData(PageRequest page){
		return employeeRepository.findAll(page);
	}
	
	public List<Employee> getByDepartment(String department){
		return employeeRepository.getByDepartment(department);	
	}

}
