package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Category;
import com.api.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	// Get All Categories
	@GetMapping("/categories")
	public ResponseEntity<Page<Category>> getCategory(
			@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize
			)
	{
		Page<Category> category = categoryService.getCategoryByPage(page, pageSize);
		return ResponseEntity.ok(category);
	}
	
	// Get Single Category
	@GetMapping("/categories/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") int categoryId)
	{
		Category category = categoryService.getCategoryById(categoryId);
		if(category == null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(category);
	}
	
	// Add Category
	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		return new ResponseEntity<Category>(
				categoryService.addCategory(category), 
				HttpStatus.CREATED
				);
	}
	
	// Update Category
	@PutMapping("/categories/{categoryId}")
	public ResponseEntity<Category> updateCategory(
			@RequestBody Category category, 
			@PathVariable("categoryId") int categoryId)
	{
		categoryService.updateCategory(category, categoryId);
		return ResponseEntity.ok(category);
	}
	
	// Delete Category
	@DeleteMapping("/categories/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") int categoryId)
	{
		categoryService.deleteCategory(categoryId);
	}
}
