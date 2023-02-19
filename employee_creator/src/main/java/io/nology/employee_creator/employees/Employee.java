package io.nology.employee_creator.employees;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// Employee Person Info
	@Column
	private String firstName;
	
	@Column 
	private String middleName;
	
	@Column
	private String lastName;
	
	// Contact Details
	@Column
	private String email;
	
	@Column
	private String mobile;
	
	// Employment Details
	@Column
	private Boolean isPermanent;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date finishDate;
	
	@Column
	private Boolean isFullTime;
	
	@Column
	private short hoursPerWeek;
	
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
