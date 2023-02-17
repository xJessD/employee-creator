package io.nology.employee_creator.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public String hello() {
		return "Helloooooo";
	}
	
	public List<Employee> all() {
		return this.repository.findAll();
		
	}
	
	public Employee create(Employee data) {
		
		Employee newEmployee = new Employee(data.getFirstName(), data.getLastName(), data.getMobile());
		this.repository.save(newEmployee);
		
		return newEmployee;
		
	}

}
