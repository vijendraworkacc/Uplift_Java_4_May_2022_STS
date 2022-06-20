package com.te.learnspringboot.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.learnspringboot.entity.Employee;
import com.te.learnspringboot.repository.AppRepository;

@Repository
public class AppRepositoryImplementation implements AppRepository {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public List<Employee> getEmployees() {
		// TODO: Logic to get all the employees!
		return null;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public Employee saveEmployee(Employee employeeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(int employeeId, Employee employeeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
