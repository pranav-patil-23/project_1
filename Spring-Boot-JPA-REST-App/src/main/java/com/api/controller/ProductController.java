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

import com.api.model.Product;
import com.api.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// Get Products
	@GetMapping("/products")
	public ResponseEntity<Page<Product>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize) {
        Page<Product> products = productService.getProductsByPage(page, pageSize);
        return ResponseEntity.ok(products);
    }
	
	// Create Product
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		return new ResponseEntity<Product>(
				productService.createProduct(product), 
				HttpStatus.CREATED
				);
	}
	
	// Update Product
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateProduct(
			@RequestBody Product product, 
			@PathVariable("productId") int productId)
	{
		productService.updateProduct(product, productId);
		return ResponseEntity.ok(product);
	}
	
	// Delete Product
	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId)
	{
		productService.deleteProduct(productId);
	}
}
