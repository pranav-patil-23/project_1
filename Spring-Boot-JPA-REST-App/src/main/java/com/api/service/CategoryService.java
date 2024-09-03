package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.model.Category;
import com.api.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	// Get All Categories
	public Page<Category> getCategoryByPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return categoryRepository.findAll(pageable);
    }
	
	// Get Single Category
	public Category getCategoryById(int id)
	{
		return categoryRepository.findById(id);
	}
	
	// Create New Category
	public Category addCategory(Category category)
	{
		return categoryRepository.save(category);
	}
	
	// Delete Category
	public void deleteCategory(int id)
	{
		categoryRepository.deleteById(id);
	}
	
	// Update Category
	public Category updateCategory(Category category, int id)
	{
		category.setCid(id);
		return categoryRepository.save(category);
	}
}
