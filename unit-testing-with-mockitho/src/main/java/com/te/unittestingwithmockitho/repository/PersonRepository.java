package com.te.unittestingwithmockitho.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.unittestingwithmockitho.entiry.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
	Optional<Person> findByPersonId(String personId);
}
