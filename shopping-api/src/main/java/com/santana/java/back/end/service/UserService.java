package com.santana.java.back.end.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.santana.java.back.end.dto.UserDTO;
import com.santana.java.back.end.exception.UserNotFoundException;

@Service
public class UserService {

	@Value("${USER_API_URL:http://localhost:8080}")
	private String userApiURL;
	
	public UserDTO getUserByCpf(String cpf, String key) {
		try {
			RestTemplate restTemplate = new RestTemplate();		
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userApiURL + "/user/cpf/" + cpf);
		    builder.queryParam("key", key);
		    
			ResponseEntity<UserDTO> response = restTemplate.getForEntity(builder.toUriString(), UserDTO.class);			
			return response.getBody();		
		} catch (HttpClientErrorException.NotFound e) {
			throw new UserNotFoundException();
		}
	}

}
