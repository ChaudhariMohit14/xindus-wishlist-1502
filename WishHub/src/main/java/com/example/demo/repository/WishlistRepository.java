package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.WishListProduct;

public interface WishlistRepository extends JpaRepository<WishListProduct, Long> {

	List<WishListProduct> findByUserId(Long userId);
}
