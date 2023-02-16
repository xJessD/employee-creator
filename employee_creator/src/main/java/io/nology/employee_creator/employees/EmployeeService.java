package io.nology.employee_creator.employees;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	public String hello() {
		return "Helloooooo";
	}

}
