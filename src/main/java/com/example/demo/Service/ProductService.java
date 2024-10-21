package com.example.demo.Service;

import java.util.*;

import com.example.demo.model.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product createProduct(Product product);
	Product getProduct(Long id);
	Product updateProduct(Long id, Product product);
	void deleteProduct(Long id);
}
