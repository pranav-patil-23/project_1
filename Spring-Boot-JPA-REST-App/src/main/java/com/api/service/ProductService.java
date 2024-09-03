package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.model.Product;
import com.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	// Get All Products
	public Page<Product> getProductsByPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return productRepository.findAll(pageable);
    }
	
	// Get Single Category
	public Product getProductById(int id)
	{
		return productRepository.findById(id);
	}
	
	// Create New Product
	public Product createProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	// Delete Product
	public void deleteProduct(int id)
	{
		productRepository.deleteById(id);
	}
	
	// Update Product
	public Product updateProduct(Product product, int id)
	{
		product.setPid(id);
		return productRepository.save(product);
	}
}
