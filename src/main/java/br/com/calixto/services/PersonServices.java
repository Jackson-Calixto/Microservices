package br.com.calixto.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.calixto.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Jackson");
		person.setLastName("Calixto");
		person.setAddress("Araquari - Santa Catarina - Brazil");
		person.setGender("Male");
		return person;
	}
}
