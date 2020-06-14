package com.santana.java.back.end.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santan.java.back.end.converter.DTOConverter;
import com.santana.java.back.end.dto.ProductDTO;
import com.santana.java.back.end.exception.CategoryNotFoundException;
import com.santana.java.back.end.exception.ProductNotFoundException;
import com.santana.java.back.end.model.Category;
import com.santana.java.back.end.model.Product;
import com.santana.java.back.end.repository.CategoryRepository;
import com.santana.java.back.end.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
		
	public List<ProductDTO> getAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(DTOConverter::convert).collect(Collectors.toList());		
	}
	
	public List<ProductDTO> getProductByCategoryId(Long categoryId) {
		List<Product> products = productRepository.getProductByCategory(categoryId);
		return products.stream().map(DTOConverter::convert).collect(Collectors.toList());		
	}
		
	public ProductDTO findByProductIdentifier(String  productIdentifier) {
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		if (product != null) {
			return DTOConverter.convert(product);
		}
		throw new ProductNotFoundException();
	}
	
	public ProductDTO save(ProductDTO productDTO) {
		Boolean existsCategory = categoryRepository.existsById(productDTO.getCategory().getId());
		if (!existsCategory) {
			throw new CategoryNotFoundException();
		}				
		Product product = productRepository.save(Product.convert(productDTO));
		return DTOConverter.convert(product);
	}
	
	public ProductDTO delete(long ProductId) throws ProductNotFoundException {
		Optional<Product> Product = productRepository.findById(ProductId);
		if (Product.isPresent()) {
			productRepository.delete(Product.get());
		}
		throw new ProductNotFoundException();
	}
	
}
