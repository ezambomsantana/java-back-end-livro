package com.santana.java.back.end.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.santana.java.back.end.dto.UserDTO;

@Service
public class UserService {
	
	public UserDTO getUserByCpf(String cpf) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8080/user/" + cpf;
		
		ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);
				
		return response.getBody();
		
	}

}
