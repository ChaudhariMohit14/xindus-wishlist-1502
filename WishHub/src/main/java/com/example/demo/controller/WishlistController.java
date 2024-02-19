package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.WishListProduct;
import com.example.demo.service.WishlistService;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {
	
	private final WishlistService wishlistService;

	@Autowired
	public WishlistController(WishlistService wishlistService) {
		super();
		this.wishlistService = wishlistService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<WishListProduct>> getUserWishlist(@AuthenticationPrincipal UserDetails userDetails){
		Long userId = getUserId(userDetails);
		
		List<WishListProduct> wishlist = wishlistService.getUserWishlist(userId);
		
		return new ResponseEntity<>(wishlist, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<WishListProduct> createWishlistItem(@RequestBody WishListProduct wishListProduct, @AuthenticationPrincipal UserDetails userDetails){
		Long userId = getUserId(userDetails);
		
		wishListProduct.getUser().setId(userId);
		
		WishListProduct createItem = wishlistService.createWishlistItem(wishListProduct);
		
		return new ResponseEntity<>(createItem, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping
	public ResponseEntity<Void> removeWishlistItem(@PathVariable Long id){
		
		wishlistService.removeWishlistItem(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	private Long getUserId(UserDetails userDetails) {
		return Long.parseLong(userDetails.getUsername());
	}
	
	
	
	

}
