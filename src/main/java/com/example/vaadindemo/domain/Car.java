package com.example.vaadindemo.domain;

public class Car {
	
	private Long id;
	private String make = "unknown";
	private String model = "unknown";
	private int yop = 1900;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	
	public String toString(){
		return "Make " + make + " Model " + model;
	}

}
