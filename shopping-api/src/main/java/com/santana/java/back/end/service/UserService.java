package com.santana.java.back.end.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.santana.java.back.end.dto.UserDTO;
import com.santana.java.back.end.exception.UserNotFoundException;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Value("${USER_API_URL:http://localhost:8080}")
	private String userApiURL;
	
	public UserDTO getUserByCpf(String cpf, String key) {
		try {
			WebClient webClient = WebClient.builder()
					.baseUrl(userApiURL)
					.build();

			Mono<UserDTO> user = webClient.get()
					.uri("/user/" + cpf + "/cpf?key="+key)
					.retrieve()
					.bodyToMono(UserDTO.class);

			return user.block();
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
	}

}
