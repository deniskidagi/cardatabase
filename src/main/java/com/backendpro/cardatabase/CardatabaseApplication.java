package com.backendpro.cardatabase;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backendpro.cardatabase.domain.Car;
import com.backendpro.cardatabase.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger =
			LoggerFactory.getLogger(CardatabaseApplication.class);
	
	private final CarRepository repository;
	
	public CardatabaseApplication(CarRepository repository) {
		this.repository = repository;
	}
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		
		
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Car("Ford", "Mustang", "Red", "ADF 1121", 2023, 29000));
		repository.save(new Car("Audi", "Rs8", "Red", "ADF 1121", 2024, 99000));
		repository.save(new Car("Toyota", "Land Cruiser", "Black", "ADF 1121", 2021, 50000));
		repository.save(new Car("Nissan", "GT R", "red", "ADF 1121", 2019, 29000));
		
		for(Car car: repository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}
		
	}

}
