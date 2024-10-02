package com.ct5106.cars3.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

	List<Car> findByMake(String make);

	List<Car> findByYearRegistered(int year);

	List<Car> findByMakeAndModel(String make, String model);

	List<Car> findByMakeOrModel(String make, String model);

	List<Car> findByMakeOrderByPriceDesc(String make);

	// Fetch cars by price range using JPQL
	@Query("SELECT c FROM Car c WHERE c.price BETWEEN :low AND :high")
	List<Car> findByPriceBetween(@Param("low") double low, @Param("high") double high);

	// Fetch cars with registration containing county string
	List<Car> findByRegistrationContaining(String county);
}
