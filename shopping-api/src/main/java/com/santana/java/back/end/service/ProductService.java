package com.santana.java.back.end.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.santana.java.back.end.dto.ProductDTO;
import com.santana.java.back.end.exception.ProductNotFoundException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	@Value("${PRODUCT_API_URL:http://localhost:54880}")
	private String productApiURL;
	
	public ProductDTO getProductByIdentifier(String productIdentifier) {

		try {
			WebClient webClient = WebClient.builder()
					.baseUrl(productApiURL)
					.build();

			Mono<ProductDTO> product = webClient.get()
					.uri("/product/" + productIdentifier)
					.retrieve()
					.bodyToMono(ProductDTO.class);

			return product.block();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductNotFoundException();
		}

	}

}
