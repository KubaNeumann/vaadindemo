package com.example.vaadindemo.domain;

import java.util.UUID;

public class Person {
	
	private UUID id;
	
	private String firstName;
	
	private int yob;
	
	private String lastName;
	
	public Person(String firstName, int yob, String lastName) {
		super();
		this.firstName = firstName;
		this.yob = yob;
		this.lastName = lastName;
	}

	public Person() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", yob=" + yob
				+ ", lastName=" + lastName + "]";
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
}
