package com.example.vaadindemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.vaadindemo.domain.Person;

public class PersonManager {
	
	private List<Person> db = new ArrayList<Person>();
	
	public void addPerson(Person person){
		Person p = new Person(person.getFirstName(), person.getYob(), person.getLastName());
		p.setId(UUID.randomUUID());
		db.add(p);
	}
	
	public List<Person> findAll(){
		return db;
	}

	public void delete(Person person) {
		
		Person toRemove = null;
		for (Person p: db) {
			if (p.getId().compareTo(person.getId()) == 0){
				toRemove = p;
				break;
			}
		}
		db.remove(toRemove);		
	}

	public void updatePerson(Person person) {
		// TODO DOIT YOURSELF
		
	}

}
