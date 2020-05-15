package com.retail.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.management.entity.Product;
import com.retail.management.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/allProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/getProduct")
	public Product getProduct(@RequestParam(name = "productId") Long productId) {
		if (productService.getProduct(productId).isPresent()) {
			return productService.getProduct(productId).get();
		} else {
			return new Product();
		}
	}

	@PostMapping(path = "/createProduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/update/{productId}")
	public String updateProduct(@RequestBody Product product, @PathVariable Long productId) {
		if (productService.getProduct(productId).isPresent()) {
			productService.updateProduct(product, productId);
			return "Product is updated "+ productId.toString();
		} else {
			return "Product is not available "+ productId.toString();

		}
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable Long productId) {
		if (productService.getProduct(productId).isPresent()) {
			productService.deleteProduct(productId);
			return "Product deleted which is associated with productId:" + productId.toString();
		} else {
			return "There is no Product which is associated with productId:" + productId.toString();
		}
	}

}
