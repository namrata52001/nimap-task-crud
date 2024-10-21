package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Category;

public interface CategoryService {

	List<Category> getAllCategory();
	Category createCategory(Category category);
	Category getCategory(Long id);
	Category updateCategory(Long id, Category category);
	void deleteCategory(Long id);
}
