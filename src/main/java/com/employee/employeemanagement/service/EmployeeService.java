package com.employee.employeemanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.employee.employeemanagement.model.Employee;

public interface EmployeeService {

	public Employee saveEmployeeDetails(Employee employee);
	
	public String displayNumbers();

	public List<Employee> getTopEmployees(int size);

	public List<Employee> getEmployeesBasedOnJoiningDate(String joiningDate);

	public Stream<LocalDate> fetchNextWeekWorkingDays();

	public Map<String, List<Employee>> fetchCategorizeEmployees();

	public List<Employee> getDNACandidateList();

	
}
