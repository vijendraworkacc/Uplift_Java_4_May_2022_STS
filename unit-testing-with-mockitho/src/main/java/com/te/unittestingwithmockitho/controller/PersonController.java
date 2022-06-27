package com.te.unittestingwithmockitho.controller;

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

import com.te.unittestingwithmockitho.entiry.dto.PersonDto;
import com.te.unittestingwithmockitho.response.GeneralResponse;
import com.te.unittestingwithmockitho.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class PersonController {

	private final PersonService personService;

	@GetMapping(path = "/person/{personId}")
	public ResponseEntity<GeneralResponse> getPerson(@PathVariable String personId) {
		PersonDto personDto = personService.getPerson(personId);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "Data given!", personDto));
	}

	@PostMapping(path = "/person")
	public ResponseEntity<GeneralResponse> savePerson(@RequestBody PersonDto personDto) {
		personDto = personService.savePerson(personDto);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "Data saved!", personDto));
	}

	@PutMapping(path = "/person/{personId}")
	public ResponseEntity<GeneralResponse> updatePerson(@PathVariable String personId,
			@RequestBody PersonDto personDto) {
		personDto = personService.updatePerson(personId, personDto);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, "Data updated!", personDto));
	}

	@DeleteMapping(path = "/person/{personId}")
	public ResponseEntity<GeneralResponse> deletePerson(@PathVariable String personId) {
		boolean deletePerson = personService.deletePerson(personId);
		return ResponseEntity.ok().body(new GeneralResponse(HttpStatus.OK, null, null, deletePerson));
	}
}
