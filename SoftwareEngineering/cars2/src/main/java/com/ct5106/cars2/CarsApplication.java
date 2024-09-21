package com.ct5106.cars2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ct5106.cars2.domain.Car;
import com.ct5106.cars2.domain.CarRepository;
import com.ct5106.cars2.domain.Owner;
import com.ct5106.cars2.domain.OwnerRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CarsApplication implements CommandLineRunner
{

	private final CarRepository repository;
	private final OwnerRepository orepository;

	private static final Logger logger = LoggerFactory.getLogger(CarsApplication.class);

	public CarsApplication(CarRepository repository, OwnerRepository orepository)
	{
		this.repository = repository;
		this.orepository = orepository;
	}

	public static void main(String[] args)
	{

		SpringApplication.run(CarsApplication.class, args);

		logger.info("Application started");

	}

	@Override
	public void run(String... args) throws Exception 
	{
		Owner owner1 = new Owner("Tom" , "Murphy");
		Owner owner2 = new Owner("Sarah" , "Jones");
		orepository.save(owner1);
		orepository.save(owner2);
		
		repository.save(new Car("Ford", "Focus", "Black","191 G 567", 1991, 18500, owner1));
		repository.save(new Car("Toyota", "Corolla", "Blue",	"241 D 12345", 2024, 36000, owner1));
		repository.save(new Car("Hyundai", "Santa Fe",	"White", "95 G 343", 1995, 1500, owner1));
		
		repository.save(new Car("Ford", "Avensis", "Green","83 G 444", 1983, 200, owner2));
		repository.save(new Car("Toyota", "Corolla", "Silver",	"201 C 3333", 2001, 500, owner2));
		repository.save(new Car("Hyundai", "Santa Fe",	"White", "232 MO 456", 2023, 45000, owner2));

		//Fetch all cars and log to console
		
		for (Car car : repository.findAll()) 
		{
			logger.info("year: {}, brand: {}, model: {}", car.getYearRegistered(), car.getMake(), car.getModel());
		}
		
		//Find by make and order by price descending
		
		for (Car car : repository.findByMakeOrderByPriceDesc("Ford")) 
		{
			logger.info("year: {}, brand: {}, model: {}, price: {}", car.getYearRegistered(), car.getMake(), car.getModel(), car.getPrice());
		}
		
		//Find by price range
		
		for (Car car : repository.findByPriceBetween(20000.00, 50000.00))
		{
			logger.info("year: {}, brand: {}, model: {}, price: {}", car.getYearRegistered(), car.getMake(), car.getModel(), car.getPrice());
		}
		
		//Find by county
		
		for (Car car : repository.findByRegistrationContaining("G"))
		{
			logger.info("reg: {}", car.getRegistration());
		}
		
	}
}
