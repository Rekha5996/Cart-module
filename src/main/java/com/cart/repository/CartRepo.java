package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
