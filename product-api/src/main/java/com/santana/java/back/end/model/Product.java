package com.santana.java.back.end.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.santana.java.back.end.dto.ProductDTO;

@Entity(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private String sku;
	
	private Float preco;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public static Product convert(ProductDTO productDTO) {
		Product product = new Product();
		product.setNome(productDTO.getNome());
		product.setPreco(productDTO.getPreco());
		product.setSku(productDTO.getSku());
		return product;
	}

}
