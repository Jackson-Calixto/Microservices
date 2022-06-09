package br.com.calixto.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.calixto.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson();
			persons.add(person);
		}
		
		return persons;
	}

	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Jackson");
		person.setLastName("Calixto");
		person.setAddress("Araquari - Santa Catarina - Brazil");
		person.setGender("Male");
		return person;
	}
	
	private Person mockPerson() {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("First Name " + person.getId());
		person.setLastName("Last Name " + person.getId());
		person.setAddress("Brazil " + person.getId());
		person.setGender("Male");
		return person;
	}
}
