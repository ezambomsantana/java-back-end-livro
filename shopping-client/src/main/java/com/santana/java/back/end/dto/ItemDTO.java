package com.santana.java.back.end.dto;

public class ItemDTO {
	
	private String productIdentifier;
	private Float price;
	
	public String getProductIdentifier() {
		return productIdentifier;
	}
	
	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}

}
