package com.example.vaadindemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.vaadindemo.domain.Car;

public class StorageService {

	private List<Car> cars = new ArrayList<Car>();

	public void addCar(Car car) {
		Car c = new Car();
		c.setId(car.getId());
		c.setMake(car.getMake());
		c.setModel(car.getModel());
		c.setYop(car.getYop());
		cars.add(c);
	}

	public List<Car> getAllCars() {
		return cars;
	}

	public void deleteCar(Car c) {
		Car toRemove = null;
		for (Car car : cars){
			if (car.getId() == c.getId()) {
				toRemove = car;
				break;
			}
		}
		cars.remove(toRemove);
	}

}
