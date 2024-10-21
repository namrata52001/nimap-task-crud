package com.example.demo.Controllers;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService; // Change to ProductService

	public ProductController(ProductService productService) {
		this.productService = productService; // Inject ProductService
	}

//	@PostMapping
//	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
//	}
	@PostMapping // This annotation is important for supporting POST requests
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) { // Use @PathVariable
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) { // Use
																												// @PathVariable
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) { // Use @PathVariable
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product deleted");
	}
}
