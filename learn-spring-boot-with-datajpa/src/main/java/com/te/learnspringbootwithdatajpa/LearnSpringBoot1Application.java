package com.te.learnspringbootwithdatajpa;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.te.learnspringbootwithdatajpa.entity.Address;
import com.te.learnspringbootwithdatajpa.entity.Employee;
import com.te.learnspringbootwithdatajpa.entity.enums.AddressType;
import com.te.learnspringbootwithdatajpa.entity.enums.BloodGroup;
import com.te.learnspringbootwithdatajpa.entity.enums.Degree;
import com.te.learnspringbootwithdatajpa.entity.enums.Gender;
import com.te.learnspringbootwithdatajpa.entity.enums.Nationality;
import com.te.learnspringbootwithdatajpa.repository.EmployeeRepository;

@SpringBootApplication
public class LearnSpringBoot1Application {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBoot1Application.class, args);
	}

	@Bean
	public CommandLineRunner saveInDb(EmployeeRepository employeeRepository) {
		return args -> {
			Optional<Employee> findByEmployeeId = employeeRepository.findByEmployeeId("TY001");
			if (!findByEmployeeId.isPresent()) {
				Employee employee = new Employee();
				employee.setEmployeeId("TY001");
				employee.setEmployeeName("Name01");
				employee.setEmployeeEmail("name@email.com");
				employee.setEmployeeDateOfBirth(LocalDate.now());
				employee.setEmployeeDateOfJoining(LocalDate.now());
				employee.setEmployeeDesignation("Manager");
				employee.setEmployeeNationality(Nationality.INDIA);
				employee.setEmployeeGender(Gender.MALE);
				employee.setEmployeeBloodGroup(BloodGroup.O_POSITIVE);
				employee.setEmploeeDegree(Degree.BE_CSE);
				Address address = new Address();
				address.setAddressType(AddressType.PERMANENT);
				address.setCity("Banglore");
				employee.setAddresses(Arrays.asList(address));
				employeeRepository.save(employee);
			}
		};
	}
}
