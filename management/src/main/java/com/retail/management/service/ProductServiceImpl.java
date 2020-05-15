package com.retail.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.management.entity.Product;
import com.retail.management.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		if (productRepository.isProductExists(product.getBarcode())) {
			throw new IllegalArgumentException("Barcode already exists.");
		}
		productRepository.save(product);
		return product;

	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(long productId) {
		return productRepository.findById(productId);
	}

	@Override
	public void updateProduct(Product product, Long productId) {
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);

	}

}
