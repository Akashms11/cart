package com.shopping.cart.controller;

import com.shopping.cart.exceptions.ResourceNotFoundException;
import com.shopping.cart.model.Items;
import com.shopping.cart.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/")
public class ShoppingCartController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
    @Autowired
    private CartRepository cartRepository;

    // Get all Items of the cart
    @GetMapping("/allItems")
    public List<Items> getAllItemsOfCart() {
        logger.info("Fetching All Items from the Shopping Cart");
        return cartRepository.findAll();
    }

    // Add items rest API
    @PostMapping("/addItems")
    public Items addItem(@RequestBody Items items) {
        logger.info("Adding Items to the Shopping Cart {}", items);
        return cartRepository.save(items);
    }

    // Get Item By ID
    @GetMapping("/item/{id}")
    public ResponseEntity<Items> getCartById(@PathVariable Long id) {
        logger.info("Fetching Item from the cart by id {}", id);
        Items shoppingCart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
        return ResponseEntity.ok(shoppingCart);
    }

    // Update quantity of item in a cart by ID
    @PutMapping("/Item/{id}")
    public ResponseEntity<Items> updateItem(@PathVariable Long id, @RequestParam("quantity") int quantity) {
        logger.info("updating item of the cart by id", id);
        Items items = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
        items.setQuantity(quantity);
        Items updateItemQuantity = cartRepository.save(items);
        return ResponseEntity.ok(updateItemQuantity);
    }

    // Delete Item rest api
    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id) {
        logger.info("Deleting Item of the cart by id {}", id);
        Items items = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not exist with id :" + id));
        cartRepository.delete(items);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
