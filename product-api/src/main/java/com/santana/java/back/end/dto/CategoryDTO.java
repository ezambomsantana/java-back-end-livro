package com.santana.java.back.end.dto;

import com.santana.java.back.end.model.Category;

public class CategoryDTO {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static CategoryDTO convert(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setNome(category.getNome());
		return categoryDTO;
	}	
	
}
