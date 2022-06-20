package com.te.learnspringboot.repository;

import java.util.List;

import com.te.learnspringboot.entity.Employee;

public interface AppRepository {
	public abstract List<Employee> getEmployees();

	public abstract Employee getEmployee(int employeeId);

	public abstract Employee saveEmployee(Employee employeeDto);

	public abstract Employee updateEmployee(int employeeId, Employee employeeDto);

	public abstract boolean deleteEmployee(int employeeId);
}
