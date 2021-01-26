package com.employee.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.employeemanagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "select * from employee e where e.joining_date >=:dateFormat", nativeQuery=true)
	List<Employee> findByJoiningDateGreaterThan(String dateFormat);
	
	//List<Employee> findByJoiningDateGreaterThan(@Param(value = "dateFormat") String dateFormat);
	
	

}
