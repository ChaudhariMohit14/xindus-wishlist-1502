package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.WishListProduct;
import com.example.demo.repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {
	
	private final WishlistRepository wishlistRepository;
	
	@Autowired
	public WishlistServiceImpl(WishlistRepository wishlistRepository) {
		super();
		this.wishlistRepository = wishlistRepository;
	}

	@Override
	public List<WishListProduct> getUserWishlist(Long userId) {
		return wishlistRepository.findByUserId(userId);
	}

	@Override
	public WishListProduct createWishlistItem(WishListProduct wishlistItem) {
		return wishlistRepository.save(wishlistItem);
	}

	@Override
	public void removeWishlistItem(Long itemId) {
		wishlistRepository.deleteById(itemId);
		
	}
	
	

}
