package com.shopping.cart;

import com.shopping.cart.model.Items;
import com.shopping.cart.repository.CartRepository;
import org.h2.engine.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CartApplicationTests {
	@Mock
	private CartRepository cartRepository;

	private static final Logger logger = LoggerFactory.getLogger(CartApplicationTests.class);

	@Test
	void contextLoads() {
	}

	@Test
	void getAllUsers(){
		logger.info("Test Executed for get all items added in shopping cart");
		Items items = new Items();
		items.setQuantity(5);
		items.setDescription("Paper Sheets");
		items.setTitle("Paper");
		List<Items> list = new ArrayList<>();
		list.add(items);
		Mockito.when(cartRepository.findAll()).thenReturn(list);
	}
	//In Same way we can add all the test for all the Operations
	// Performed and verify them as per required Lines to be covered

}
