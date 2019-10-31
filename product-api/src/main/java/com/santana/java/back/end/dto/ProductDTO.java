package com.santana.java.back.end.dto;

import com.santana.java.back.end.model.Product;

public class ProductDTO {

	private String nome;
	private String sku;
	private Float preco;

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

	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		productDTO.setSku(product.getSku());
		return productDTO;
	}
	
}
