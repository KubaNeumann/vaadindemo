package com.example.vaadindemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.vaadindemo.domain.Person;

public class StorageService {
	
	private List<Person> db = new ArrayList<Person>();
	
	public void add(Person o){
		db.add(o);
	}
	
    public List<Person> getAllPersons(){
    	return db;
    }
    
    public void deletePerson(Person o){
    	db.remove(o);
    }

}
