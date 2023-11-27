package com.dgmf;

import com.dgmf.entity.Product;
import com.dgmf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = Product.builder()
				.name("Computer")
				.price(4300L)
				.quantity(3)
				.build();

		Product product2 = Product.builder()
				.name("Printer")
				.price(1200L)
				.quantity(18)
				.build();

		Product product3 = Product.builder()
				.name("Smart Phone")
				.price(1200L)
				.quantity(32)
				.build();

		// Additions of 3 Products in the DB
		List<Product> products = productRepository.saveAll(
				Arrays.asList(product1, product2, product3)
		);

		// Retrieval and display of the 3 Products in the Console
		List<Product> productList = productRepository.findAll();
		productList.forEach(product -> System.out.println(product));
	}
}
