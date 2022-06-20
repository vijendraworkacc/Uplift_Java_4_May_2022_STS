package com.te.learnspringbootwithdatajpa.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.te.learnspringbootwithdatajpa.entity.dto.EmployeeDto;
import com.te.learnspringbootwithdatajpa.response.GeneralResponse;
import com.te.learnspringbootwithdatajpa.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping(path = "/employees")
	public ResponseEntity<GeneralResponse> getAllEmployees() {
		return ResponseEntity.ok()
				.body(new GeneralResponse(
						ServletUriComponentsBuilder.fromCurrentContextPath().path("/employees").toUriString(),
						HttpStatus.OK, null, "Data provided!", employeeService.findAllEmployees()));
	}

	@GetMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable String employeeId) {
		return ResponseEntity.ok()
				.body(new GeneralResponse(
						ServletUriComponentsBuilder.fromCurrentContextPath().path("/employees/" + employeeId)
								.toUriString(),
						HttpStatus.OK, null, "Data provided!", employeeService.findByEmployeeId(employeeId)));
	}

	@PostMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> registerEmployee(@RequestBody EmployeeDto employeeDto) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/employee").toUriString());
		return ResponseEntity.created(uri).body(new GeneralResponse(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("/employee").toUriString(),
				HttpStatus.CREATED, null, "Employee registered!", employeeService.registerEmployee(employeeDto)));
	}

	@PutMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> updateEmployee(@PathVariable String employeeId,
			@RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.accepted()
				.body(new GeneralResponse(
						ServletUriComponentsBuilder.fromCurrentContextPath().path("/employee/" + employeeId)
								.toUriString(),
						HttpStatus.ACCEPTED, null, "Employee updated!",
						employeeService.updateEmployee(employeeId, employeeDto)));
	}
}
