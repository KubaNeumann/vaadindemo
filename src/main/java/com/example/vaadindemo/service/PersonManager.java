package com.example.vaadindemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.vaadindemo.domain.Person;

public class PersonManager {
	
	private List<Person> db = new ArrayList<Person>();
	
	public void addPerson(Person person){
		Person p = new Person(person.getFirstName(), person.getYob(), person.getLastName());
		db.add(p);
	}
	
	public List<Person> findAll(){
		return db;
	}

}
