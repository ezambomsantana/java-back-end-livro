package com.santana.java.back.end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotBlank
	private String productIdentifier;
    @NotBlank
	private String nome;
    @NotNull
    private Float preco;
    @NotNull
	private CategoryDTO category;
	
}
