package com.practice.practice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.practice.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query("select e from Employee e where e.department = :department")
	public List<Employee> getByDepartment(@Param("department") String department);
}
