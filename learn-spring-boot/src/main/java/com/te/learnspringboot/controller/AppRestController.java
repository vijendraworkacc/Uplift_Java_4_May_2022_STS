package com.te.learnspringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.learnspringboot.entity.dto.EmployeeDto;
import com.te.learnspringboot.response.GeneralResponse;
import com.te.learnspringboot.service.AppService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/c1")
@RequiredArgsConstructor
public class AppRestController {

	private final AppService appService;

	@GetMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> getEmployees() {
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "Provided!", "List of employee!"));
	}

	@GetMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable int employeeId) {
		EmployeeDto employeeDto = appService.getEmployee(employeeId);
		if (employeeDto != null) {
			return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "Provided!", employeeDto));
		}
		return ResponseEntity.badRequest()
				.body(new GeneralResponse(HttpStatus.BAD_REQUEST, "Data not found!", null, null));
	}

	@PostMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "Saved!", employeeDto));
	}

	@PutMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> updateEmployee(@PathVariable int employeeId,
			@RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "Updated!", employeeDto));
	}

	@DeleteMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> deleteEmployee(@PathVariable int employeeId) {
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "Deleted!", "Deleted employee data!"));
	}

}
