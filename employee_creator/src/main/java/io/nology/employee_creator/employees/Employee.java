package io.nology.employee_creator.employees;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column
	String firstName;
	
	@Column 
	String middleName;
	
	@Column
	String lastName;
	
	@Column
	String email;
	
}
