package com.te.unittestingwithmockitho.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.te.unittestingwithmockitho.entiry.dto.PersonDto;

public class PersonServiceTest {
	
	private PersonService personService = mock(PersonService.class);
	
	@Test
	public void getPerson_basicTest() {
		PersonDto personDto = new PersonDto("p01", "name01", 22, "p@p.com");
		when(personService.getPerson("p01")).thenReturn(personDto);
		PersonDto person = personService.getPerson("p01");
		assertThat(person).isNotNull();
		assertEquals(personDto.getPersonName(), person.getPersonName());
	}
	
	@Test
	public void savePerson_basicTest() {
		PersonDto personDto = new PersonDto("p01", "name01", 22, "p@p.com");
		when(personService.savePerson(personDto)).thenReturn(personDto);
		
		PersonDto savePerson = personService.savePerson(personDto);
		
		assertThat(savePerson).isNotNull();
		assertEquals(personDto.getPersonAge(), savePerson.getPersonAge());
	}
}
