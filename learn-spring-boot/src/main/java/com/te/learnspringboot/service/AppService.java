package com.te.learnspringboot.service;

import java.util.List;

import com.te.learnspringboot.entity.dto.EmployeeDto;

public interface AppService {
	public abstract List<EmployeeDto> getEmployees();

	public abstract EmployeeDto getEmployee(int employeeId);

	public abstract EmployeeDto saveEmployee(EmployeeDto employeeDto);

	public abstract EmployeeDto updateEmployee(int employeeId, EmployeeDto employeeDto);

	public abstract boolean deleteEmployee(int employeeId);
}
