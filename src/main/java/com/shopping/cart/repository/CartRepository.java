package com.shopping.cart.repository;

import com.shopping.cart.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Items, Long> {

}
