package com.example.demo.service;

import java.util.List;

import com.example.demo.model.WishListProduct;

public interface WishlistService {
	
	List<WishListProduct> getUserWishlist(Long userId);
	WishListProduct createWishlistItem(WishListProduct wishlistItem);
    void removeWishlistItem(Long itemId);

}
