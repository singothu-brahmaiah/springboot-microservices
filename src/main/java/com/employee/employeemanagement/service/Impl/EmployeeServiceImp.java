package com.employee.employeemanagement.service.Impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeemanagement.model.Employee;
import com.employee.employeemanagement.repository.EmployeeRepository;
import com.employee.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		employee.setJoiningDate(LocalDateTime.now());
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getTopEmployees(int size) {
		Iterable<Employee> employees = employeeRepository.findAll();
		List<Employee> empList = ((Collection<Employee>) employees).stream()
				.sorted((e1, e2) -> e2.getJoiningDate().compareTo(e1.getJoiningDate())).limit(size)
				.collect(Collectors.toList());

		return empList;
	}

	@Override
	public Stream<LocalDate> fetchNextWeekWorkingDays() {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

		switch (dayOfWeek) {
		case THURSDAY: {
			return print(LocalDate.now().plusDays(4));
		}
		case FRIDAY: {
			return print(LocalDate.now().plusDays(3));
		}
		case SATURDAY: {
			return print(LocalDate.now().plusDays(2));
		}
		case SUNDAY: {
			return print(LocalDate.now().plusDays(1));
		}
		case MONDAY: {
			return print(LocalDate.now().plusDays(7));
		}
		case TUESDAY: {
			return print(LocalDate.now().plusDays(6));
		}
		case WEDNESDAY: {
			return print(LocalDate.now().plusDays(5));
		}
		default:
			break;
		}
		return null;
	}

	private Stream<LocalDate> print(LocalDate plusDays) {
		return IntStream.range(0, 5).mapToObj(n -> plusDays.plusDays(n));
	}

	@Override
	public List<Employee> getEmployeesBasedOnJoiningDate(String joiningDate) {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return employees.stream()
				.filter(e -> e.getJoiningDate().format(dateTimeFormatter).equalsIgnoreCase(joiningDate))
				.collect(Collectors.toList());
	}

	@Override
	public Map<String, List<Employee>> fetchCategorizeEmployees() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		Map<String, List<Employee>> e = employees.stream().collect(Collectors.groupingBy(Employee::getDesignation));
		return e;
	}

	@Override
	public List<Employee> getDNACandidateList() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		return employees.stream().filter(e -> Double.valueOf(e.getEmpExperience()) > Double.valueOf(7))
				.collect(Collectors.toList());
	}

	@Override
	public String displayNumbers() {
		IntStream closedRangeStream = IntStream.rangeClosed(1, 100);
		closedRangeStream.forEach(System.out::println);
		return "Sucessfully display";
	}

}
