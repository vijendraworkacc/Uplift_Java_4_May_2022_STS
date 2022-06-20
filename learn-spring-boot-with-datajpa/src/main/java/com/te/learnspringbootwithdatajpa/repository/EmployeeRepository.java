package com.te.learnspringbootwithdatajpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learnspringbootwithdatajpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	Optional<Employee> findByEmployeeId(String employeeId);
}
