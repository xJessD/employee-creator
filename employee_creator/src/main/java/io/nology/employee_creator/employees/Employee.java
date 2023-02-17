package io.nology.employee_creator.employees;

import java.util.Date;

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
	
	// Employee Person Info
	@Column
	String firstName;
	
	@Column 
	String middleName;
	
	@Column
	String lastName;
	
	// Contact Details
	@Column
	String email;
	
	@Column
	String mobile;
	
	// Employment Details
	@Column
	Boolean isPermanent;
	
	@Column
	Date startDate;
	
	@Column
	Date finishDate;
	
	@Column
	Boolean isFullTime;
	
	@Column
	short hoursPerWeek;
	
	public Employee() {}
	
	public Employee(String firstName, String lastName, String mobile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
