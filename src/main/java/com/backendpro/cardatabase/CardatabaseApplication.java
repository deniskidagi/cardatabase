package com.backendpro.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backendpro.cardatabase.domain.Car;
import com.backendpro.cardatabase.domain.CarRepository;
import com.backendpro.cardatabase.domain.Owner;
import com.backendpro.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger =
			LoggerFactory.getLogger(CardatabaseApplication.class);
	
	private final CarRepository repository;
	private final OwnerRepository orepository;
	
	public CardatabaseApplication(CarRepository repository, OwnerRepository orepository) {
		this.repository = repository;
		this.orepository = orepository;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		
		
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));
		
		
		repository.save(new Car("Ford", "Mustang", "Red", "ADF 1121", 2023, 29000, owner1));
		repository.save(new Car("Audi", "Rs8", "Red", "ADF 1121", 2024, 99000, owner2));
		repository.save(new Car("Toyota", "Land Cruiser", "Black", "ADF 1121", 2021, 50000, owner1));
		repository.save(new Car("Nissan", "GT R", "red", "ADF 1121", 2019, 29000, owner2));
		
		for(Car car: repository.findAll()) {
			logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
		}
		
	}

}
