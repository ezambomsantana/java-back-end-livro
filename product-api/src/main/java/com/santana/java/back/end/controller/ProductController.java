package com.santana.java.back.end.controller;

import java.util.List;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.santana.java.back.end.dto.ProductDTO;
import com.santana.java.back.end.exception.ProductNotFoundException;
import com.santana.java.back.end.service.ProductService;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductService productService;
		
	@GetMapping
	public List<ProductDTO> getProducts() {		
		return productService.getAll();
	}
	
	@GetMapping("/category/{categoryId}")
	public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {		
		return productService.getProductByCategoryId(categoryId);
	}
		
	@GetMapping("/{productIdentifier}")
	public ProductDTO findById(@PathVariable String productIdentifier) {
	    return productService.findByProductIdentifier(productIdentifier);
	}
	
	@PostMapping
	public ProductDTO newProduct(@Valid @RequestBody ProductDTO userDTO) {
	    return productService.save(userDTO);
	}
		
	@DeleteMapping("/{id}")
	public ProductDTO delete(@PathVariable Long id) throws ProductNotFoundException {
	    return productService.delete(id);
	}

	@GetMapping("/pageable")
	public Page<ProductDTO> getProductsPage(Pageable pageable) {
		return productService.getAllPage(pageable);
	}

	@PostMapping("/{id}")
	public ProductDTO editProduct(@PathVariable Long id,
							@RequestBody ProductDTO productDTO) {
		return productService.editProduct(id, productDTO);
	}

}
