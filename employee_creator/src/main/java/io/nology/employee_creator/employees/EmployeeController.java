package io.nology.employee_creator.employees;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findOneEmployee(@PathVariable Long id) {
		Optional<Employee> maybeEmployee = this.service.findOne(id);
		
		if (maybeEmployee.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No employee found.");
		}
		
		return new ResponseEntity<>(maybeEmployee.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> create(@Valid @RequestBody EmployeeCreateDTO data) {
		Employee createdEmployee = this.service.create(data);
		
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
}
