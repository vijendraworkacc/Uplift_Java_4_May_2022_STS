package com.te.learnspringbootwithdatajpa.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee_attendence_info")
public class EmployeeAttendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attendenceId;
	private LocalDate attendenceDate;
	private boolean attendenceMorning;
	private boolean attendenceNoon;
}
