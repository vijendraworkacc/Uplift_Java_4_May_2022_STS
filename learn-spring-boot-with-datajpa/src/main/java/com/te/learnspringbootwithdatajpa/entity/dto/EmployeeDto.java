package com.te.learnspringbootwithdatajpa.entity.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.te.learnspringbootwithdatajpa.entity.Address;
import com.te.learnspringbootwithdatajpa.entity.Batch;
import com.te.learnspringbootwithdatajpa.entity.EmployeeAttendence;
import com.te.learnspringbootwithdatajpa.entity.enums.BloodGroup;
import com.te.learnspringbootwithdatajpa.entity.enums.Degree;
import com.te.learnspringbootwithdatajpa.entity.enums.EmployeeStatus;
import com.te.learnspringbootwithdatajpa.entity.enums.Gender;
import com.te.learnspringbootwithdatajpa.entity.enums.Nationality;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto {
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private LocalDate employeeDateOfBirth;
	private LocalDate employeeDateOfJoining;
	private String employeeDesignation;

	@Enumerated(EnumType.STRING)
	private Nationality employeeNationality;
	@Enumerated(EnumType.STRING)
	private Gender employeeGender;
	@Enumerated(EnumType.STRING)
	private BloodGroup employeeBloodGroup;
	@Enumerated(EnumType.STRING)
	private Degree emploeeDegree;

	private List<AddressDto> addresses;
}
