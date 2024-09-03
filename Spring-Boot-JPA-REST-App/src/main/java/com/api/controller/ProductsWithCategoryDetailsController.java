package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.CategoryDTO;
import com.api.dto.ProductDTO;
import com.api.model.Category;
import com.api.model.Product;
import com.api.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductsWithCategoryDetailsController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductDTO> getProductDetails(@PathVariable int productId)
	{
		Product product = productService.getProductById(productId);
		
		if(product == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setPid(product.getPid());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		
		Category category = product.getCategory();
		
		CategoryDTO categoryDTO = new CategoryDTO();
		
		categoryDTO.setCid(category.getCid());
		categoryDTO.setCname(category.getCname());
		
		productDTO.setCategory(categoryDTO);
		
		return ResponseEntity.ok(productDTO);
	}
}
