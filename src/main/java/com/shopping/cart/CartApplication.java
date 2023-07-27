package com.shopping.cart;

import com.shopping.cart.controller.ShoppingCartController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartApplication {
	private static final Logger logger = LoggerFactory.getLogger(CartApplication.class);


	public static void main(String[] args) {
		logger.info("Shopping Cart Application has been started..");
		SpringApplication.run(CartApplication.class, args);
	}

}
