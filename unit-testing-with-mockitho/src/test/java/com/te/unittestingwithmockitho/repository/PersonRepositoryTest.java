package com.te.unittestingwithmockitho.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.te.unittestingwithmockitho.entiry.Person;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void crud_basicTest() {
		Person person = new Person();
		person.setPersonId("p02");
		person.setPersonName("name02");
		person.setPersonEmail("p@p.com");
		person.setPersonAge(22);

		personRepository.save(person);

		Optional<Person> optional = personRepository.findByPersonId("p02");
		Person personOb = optional.get();

		assertThat(personOb).isNotNull();
		assertEquals(person.getPersonName(), personOb.getPersonName());

		personRepository.deleteAll();
		List<Person> findAll = personRepository.findAll();
		assertThat(findAll).isEmpty();
	}
}
