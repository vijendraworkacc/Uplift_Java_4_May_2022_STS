package com.te.unittestingwithmockitho.service.implementation;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.unittestingwithmockitho.entiry.Person;
import com.te.unittestingwithmockitho.entiry.dto.PersonDto;
import com.te.unittestingwithmockitho.repository.PersonRepository;
import com.te.unittestingwithmockitho.service.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImplementation implements PersonService {

	private final PersonRepository personRepository;

	@Override
	public PersonDto getPerson(String personId) {
		PersonDto personDto = new PersonDto();
		Optional<Person> findByPersonId = personRepository.findByPersonId(personId);
		if (findByPersonId.isPresent()) {
			BeanUtils.copyProperties(findByPersonId.get(), personDto);
		}
		return personDto;
	}

	@Override
	public PersonDto savePerson(PersonDto personDto) {
		Person person = new Person(personDto.getPersonId(), personDto.getPersonName(), personDto.getPersonAge(),
				personDto.getPersonEmail());
		personRepository.save(person);
		return personDto;
	}

	@Override
	public PersonDto updatePerson(String personId, PersonDto personDto) {
		Optional<Person> optional = personRepository.findByPersonId(personId);
		if (optional.isPresent()) {
			Person personFromDb = optional.get();
			Person person = new Person(personFromDb.getPersonId(), personDto.getPersonName(), personDto.getPersonAge(),
					personDto.getPersonEmail());
			personRepository.save(person);
		}
		return personDto;
	}

	@Override
	public boolean deletePerson(String personId) {
		Optional<Person> optional = personRepository.findByPersonId(personId);
		if (optional.isPresent()) {
			Person person = optional.get();
			personRepository.delete(person);
			return true;
		}
		return false;
	}

}
