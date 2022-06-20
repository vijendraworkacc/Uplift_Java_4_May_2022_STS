package com.te.learnspringbootwithdatajpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.te.learnspringbootwithdatajpa.entity.enums.BloodGroup;
import com.te.learnspringbootwithdatajpa.entity.enums.Degree;
import com.te.learnspringbootwithdatajpa.entity.enums.EmployeeStatus;
import com.te.learnspringbootwithdatajpa.entity.enums.Gender;
import com.te.learnspringbootwithdatajpa.entity.enums.Nationality;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee_primary_info")
public class Employee {
	@Id
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private LocalDate employeeDateOfBirth;
	private LocalDate employeeDateOfJoining;
	private String employeeDesignation;
	private LocalDateTime employeeLastLogin;

	@Enumerated(EnumType.STRING)
	private Nationality employeeNationality;
	@Enumerated(EnumType.STRING)
	private Gender employeeGender;
	@Enumerated(EnumType.STRING)
	private BloodGroup employeeBloodGroup;
	@Enumerated(EnumType.STRING)
	private Degree emploeeDegree;
	@Enumerated(EnumType.STRING)
	private EmployeeStatus employeeStatus;

	@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeeAttendence> employeeAttendence;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_fk")
	private Batch inBatch;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;

}
