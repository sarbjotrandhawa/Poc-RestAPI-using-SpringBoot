package com.retail.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.retail.management.entity.Product;

@Service
public interface ProductService {
	 Product createProduct(Product product);
	 List<Product> getAllProducts();
	 Optional<Product> getProduct(long productId);
	 public void updateProduct(Product product,Long productId );
	void deleteProduct(Long productId);
}
