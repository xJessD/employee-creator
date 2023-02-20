package io.nology.employee_creator.employees;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public String hello() {
		return "Testing endpoint";
	}
	
	public Employee create(@Valid EmployeeCreateDTO data) {
		String cleanedFirstName = data.getFirstName().trim();
		String cleanedLastName = data.getLastName().trim();
		String cleanedEmail = data.getEmail().trim();
		
		Employee newEmployee = new Employee(cleanedFirstName, cleanedLastName, cleanedEmail, data.getMobile());
		this.repository.save(newEmployee);
		
		return newEmployee;
		
	}
	
	public List<Employee> all() {
		return this.repository.findAll();
		
	}
	
	public Optional<Employee> findOne(Long employeeId) {
		return this.repository.findById(employeeId);
	}
	
	public boolean deleteOne(Long employeeId) {
		Optional<Employee> maybeEmployee = this.findOne(employeeId);
		
		if (maybeEmployee.isEmpty()) {
			return false;
		}
		
		this.repository.delete(maybeEmployee.get());
		return true;
	}

	

}
