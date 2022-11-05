package com.dh.productms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@EnableEurekaClient
public class ProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMsApplication.class, args);
	}

	@RestController
	@RequestMapping("/product")
	public class ProductController {

		private final ProductService service;

		public ProductController(ProductService service) {
			this.service = service;
		}

		@GetMapping(path = "/info")
		public ResponseEntity<ArrayList> getData() {
			return ResponseEntity.ok(service.getProducts());
		}
	}

	@Service
	public class ProductService {
		private ArrayList<String> products = new ArrayList<>();
		public ArrayList<String> getProducts() {

			products.add("Cartucho negro");
			products.add("Cartucho color");
			products.add("Silla Gamer");
			products.add("Escritorio mediano");
			products.add("Escritorio grande");
			products.add("Mouse Gamer");
			products.add("Mouse Pad");
			products.add("Pantalla 144Hz");
			products.add("Pantalla 60Hz");
			products.add("Pantalla 240Hz");

			return products;
		}

	}
}
