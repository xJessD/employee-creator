package io.nology.employee_creator.employees;

import java.util.List;

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
	
	public List<Employee> all() {
		return this.repository.findAll();
		
	}
	
	public Employee create(@Valid EmployeeCreateDTO data) {
		
		Employee newEmployee = new Employee(data.getFirstName(), data.getLastName(), data.getMobile());
		this.repository.save(newEmployee);
		
		return newEmployee;
		
	}

}
