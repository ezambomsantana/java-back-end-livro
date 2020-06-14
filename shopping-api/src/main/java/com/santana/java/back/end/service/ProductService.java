package com.santana.java.back.end.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.santana.java.back.end.dto.ProductDTO;
import com.santana.java.back.end.exception.ProductNotFoundException;

@Service
public class ProductService {
	
	@Value("${PRODUCT_API_URL:http://localhost:8081}")
	private String productApiURL;
	
	public ProductDTO getProductByIdentifier(String productIdentifier) {
		try {
			RestTemplate restTemplate = new RestTemplate();		
			String url = productApiURL + "/product/" + productIdentifier;
			ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
			
			if (response.getStatusCode().is4xxClientError()) {
				throw new ProductNotFoundException();
			}
			
			return response.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new ProductNotFoundException();
		}
	}

}
