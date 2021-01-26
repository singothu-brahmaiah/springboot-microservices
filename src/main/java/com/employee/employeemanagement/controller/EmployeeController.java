package com.employee.employeemanagement.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeemanagement.dto.DNACondidates;
import com.employee.employeemanagement.dto.EmployeeDetails;
import com.employee.employeemanagement.dto.EmployeeResponse;
import com.employee.employeemanagement.model.Employee;
import com.employee.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	private ModelMapper mapper;

	@PostMapping("/saveEmployee")
	public ResponseEntity<EmployeeResponse> saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		return ResponseEntity
				.ok(mapper.map(employeeService.saveEmployeeDetails(mapper.map(employeeDetails, Employee.class)),
						EmployeeResponse.class));
	}

	@GetMapping("/printNumbers")
	public String printNumber() {
		return employeeService.displayNumbers();
	}

	@GetMapping("/fetchTopEmployees")
	public ResponseEntity<List<Employee>> getTopEmployees(@RequestParam int size) {
		return ResponseEntity.ok(employeeService.getTopEmployees(size));
	}

	@GetMapping("/employeeListBasedOnJoiningDate")
	public ResponseEntity<List<Employee>> getEmployeesBasedOnJoiningDate(String joiningDate) {
		return ResponseEntity.ok(employeeService.getEmployeesBasedOnJoiningDate(joiningDate));
	}

	@GetMapping("/nextWeekWorkingDays")
	public ResponseEntity<Stream<LocalDate>> fetchNextWeekWorkingDays() {
		return ResponseEntity.ok(employeeService.fetchNextWeekWorkingDays());
	}

	@GetMapping("/categorizeEmployees")
	public ResponseEntity<Map<String, List<Employee>>> fetchCategorizeEmployees() {
		return ResponseEntity.ok(employeeService.fetchCategorizeEmployees());
	}

	@GetMapping("/dnaCandidateList")
	public ResponseEntity<List<DNACondidates>> getDNACandidateList() {

		return ResponseEntity
				.ok(mapper.map(employeeService.getDNACandidateList(), new TypeToken<List<DNACondidates>>() {
				}.getType()));
	}

}
