package com.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "category_details")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
	@SequenceGenerator(name = "category_seq_gen", sequenceName = "cat_seq")
	private int cid;
	private String cname;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Product> products;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int cid, String cname, List<Product> products) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.products = products;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
		for (Product p : products) {
			p.setCategory(this);
		}
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", products=" + products + "]";
	}

}
