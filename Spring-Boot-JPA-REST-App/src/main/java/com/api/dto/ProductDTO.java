package com.api.dto;

public class ProductDTO {

	private int pid;
	private String name;
	private double price;

	
	private CategoryDTO categoryDTO;
	
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(int pid, String name, double price, CategoryDTO categoryDTO) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.categoryDTO = categoryDTO;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CategoryDTO getCategory() {
		return categoryDTO;
	}

	public void setCategory(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	
}
