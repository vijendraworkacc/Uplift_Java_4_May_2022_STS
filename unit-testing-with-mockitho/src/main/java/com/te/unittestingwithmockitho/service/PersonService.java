package com.te.unittestingwithmockitho.service;

import com.te.unittestingwithmockitho.entiry.dto.PersonDto;

public interface PersonService {
	public abstract PersonDto getPerson(String personId);

	public abstract PersonDto savePerson(PersonDto personDto);

	public abstract PersonDto updatePerson(String personId, PersonDto personDto);

	public abstract boolean deletePerson(String personId);
}
