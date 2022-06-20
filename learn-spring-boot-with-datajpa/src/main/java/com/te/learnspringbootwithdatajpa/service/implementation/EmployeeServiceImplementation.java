package com.te.learnspringbootwithdatajpa.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.learnspringbootwithdatajpa.entity.Address;
import com.te.learnspringbootwithdatajpa.entity.Employee;
import com.te.learnspringbootwithdatajpa.entity.dto.AddressDto;
import com.te.learnspringbootwithdatajpa.entity.dto.EmployeeDto;
import com.te.learnspringbootwithdatajpa.repository.EmployeeRepository;
import com.te.learnspringbootwithdatajpa.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto findByEmployeeId(String employeeId) {
		EmployeeDto employeeDto = new EmployeeDto();
		Optional<Employee> findByEmployeeId = employeeRepository.findByEmployeeId(employeeId);
		if (findByEmployeeId.isPresent()) {
			Employee employee = findByEmployeeId.get();
			BeanUtils.copyProperties(employee, employeeDto);
			List<AddressDto> addressDtos = new ArrayList<>();
			employee.getAddresses().stream().forEach(a -> {
				AddressDto addressDto = new AddressDto();
				BeanUtils.copyProperties(a, addressDto);
				addressDtos.add(addressDto);
			});
			employeeDto.setAddresses(addressDtos);
			return employeeDto;
		}
		return null;
	}

	@Override
	public List<EmployeeDto> findAllEmployees() {
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		employeeRepository.findAll().stream().forEach(e -> {
			EmployeeDto employeeDto = new EmployeeDto();
			List<AddressDto> addressDtos = new ArrayList<>();
			BeanUtils.copyProperties(e, employeeDto);
			e.getAddresses().stream().forEach(a -> {
				AddressDto addressDto = new AddressDto();
				BeanUtils.copyProperties(a, addressDto);
				addressDtos.add(addressDto);
			});
			employeeDto.setAddresses(addressDtos);
			employeeDtos.add(employeeDto);
		});
		return employeeDtos;
	}

	@Override
	public EmployeeDto registerEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		List<Address> addresses = new ArrayList<>();
		employeeDto.getAddresses().stream().forEach(aDto -> {
			Address address = new Address();
			BeanUtils.copyProperties(aDto, address);
			addresses.add(address);
		});
		employee.setAddresses(addresses);
		employeeRepository.save(employee);
		return employeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(String employeeId, EmployeeDto employeeDto) {
		Optional<Employee> findByEmployeeId = employeeRepository.findByEmployeeId(employeeId);
		if (findByEmployeeId.isPresent()) {
			Employee employee = findByEmployeeId.get();
			BeanUtils.copyProperties(employeeDto, employee);
			List<Address> addresses = new ArrayList<>();
			employeeDto.getAddresses().stream().forEach(aDto -> {
				Address address = new Address();
				BeanUtils.copyProperties(aDto, address);
				addresses.add(address);
			});
			employee.setAddresses(addresses);
			employeeRepository.save(employee);
			return employeeDto;
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		Optional<Employee> findByEmployeeId = employeeRepository.findByEmployeeId(employeeId);
		if (findByEmployeeId.isPresent()) {
			employeeRepository.delete(findByEmployeeId.get());
			return true;
		}
		return false;
	}

}
