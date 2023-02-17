package io.nology.employee_creator.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/test")
	public String test() {
		return this.service.hello();
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> allEmployees = this.service.all();
		
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Employee> create(@RequestBody Employee data) {
		Employee createdEmployee = this.service.create(data);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
}
