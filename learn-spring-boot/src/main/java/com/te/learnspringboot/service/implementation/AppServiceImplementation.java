package com.te.learnspringboot.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.learnspringboot.entity.Employee;
import com.te.learnspringboot.entity.dto.EmployeeDto;
import com.te.learnspringboot.repository.AppRepository;
import com.te.learnspringboot.service.AppService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppServiceImplementation implements AppService {

	private final AppRepository appRepository;

	@Override
	public List<EmployeeDto> getEmployees() {
		return null;
	}

	@Override
	public EmployeeDto getEmployee(int employeeId) {
		Employee employee = appRepository.getEmployee(employeeId);
		if (employee != null) {
			EmployeeDto employeeDto = new EmployeeDto();
			BeanUtils.copyProperties(employee, employeeDto);
			return employeeDto;
		}
		return null;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		return null;
	}

	@Override
	public EmployeeDto updateEmployee(int employeeId, EmployeeDto employeeDto) {
		return null;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return false;
	}

}
