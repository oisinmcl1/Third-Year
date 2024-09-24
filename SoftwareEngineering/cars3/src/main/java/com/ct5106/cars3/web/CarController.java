package com.ct5106.cars3.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct5106.cars3.domain.Car;
import com.ct5106.cars3.domain.CarRepository;

@RestController
public class CarController
{
	private final CarRepository repository;

	public CarController(CarRepository repository)
	{
		this.repository = repository;
	}

	@GetMapping("/cars")
	public Iterable<Car> getCars()
	{
		return repository.findAll();
	}

}
