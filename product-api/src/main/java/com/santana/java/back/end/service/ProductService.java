package com.santana.java.back.end.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santan.java.back.end.converter.DTOConverter;
import com.santana.java.back.end.dto.ProductDTO;
import com.santana.java.back.end.exception.ProductNotFoundException;
import com.santana.java.back.end.model.Product;
import com.santana.java.back.end.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
		
	public List<ProductDTO> getAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(DTOConverter::convert).collect(Collectors.toList());		
	}
	
	public List<ProductDTO> getProductByCategoryId(Long categoryId) {
		List<Product> products = productRepository.getProductByCategory(categoryId);
		return products.stream().map(DTOConverter::convert).collect(Collectors.toList());		
	}
	
	
	public ProductDTO findById(long ProductId) {
		Optional<Product> usuario = productRepository.findById(ProductId);
		if (usuario.isPresent()) {
			return DTOConverter.convert(usuario.get());
		}
		throw new ProductNotFoundException();
	}
	
	public ProductDTO save(ProductDTO productDTO) {
				
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
