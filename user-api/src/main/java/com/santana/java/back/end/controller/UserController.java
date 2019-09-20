package com.santana.java.back.end.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santana.java.back.end.dto.UserDTO;

@RestController
public class UserController {
	@RequestMapping("/")
	public String home() {
		return "Spring boot is working!";

	}
	
	@RequestMapping("/user")
	public UserDTO getUser() {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome("Eduardo");
		
		return userDTO;

	}
		
}
