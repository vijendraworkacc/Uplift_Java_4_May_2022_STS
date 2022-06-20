package com.te.learnspringbootwithdatajpa.service;

import java.util.List;

import com.te.learnspringbootwithdatajpa.entity.dto.EmployeeDto;

public interface EmployeeService {

	List<EmployeeDto> findAllEmployees();

	EmployeeDto findByEmployeeId(String employeeId);

	EmployeeDto registerEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployee(String employeeId, EmployeeDto employeeDto);

	boolean deleteEmployee(String employeeId);
}
