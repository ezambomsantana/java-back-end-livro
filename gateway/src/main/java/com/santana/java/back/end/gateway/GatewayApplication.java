package com.santana.java.back.end.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


	@Value("${USER_API_URL:http://localhost:8080}")
	private String userApiURL;

	@Value("${PRODUCT_API_URL:http://localhost:8081}")
	private String productApiURL;

	@Value("${SHOPPING_API_URL:http://localhost:8082}")
	private String shoppingApiURL;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("user_route", r -> r.path("/user/**")
						.uri(userApiURL))
				.route("product_route", r -> r.path("/product/**")
						.uri(productApiURL))
				.route("shopping_route", r -> r.path("/shopping/**")
						.uri(shoppingApiURL))
				.build();

	}

}
