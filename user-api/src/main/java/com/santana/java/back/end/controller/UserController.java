package com.santana.java.back.end.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santana.java.back.end.dto.UserDTO;
import com.santana.java.back.end.exception.UserNotFoundException;
import com.santana.java.back.end.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@GetMapping("/users")
	public List<UserDTO> getUsers() {		
		List<UserDTO> usuarios = userService.getAll();		
		return usuarios;
	}
	
	@GetMapping("/user/{id}")
	UserDTO findById(@PathVariable Long id) {
	    return userService.findById(id);
	}
	
	@PostMapping("/newUser")
	UserDTO newUser(@RequestBody UserDTO userDTO) {		
	    return userService.save(userDTO);
	}
	

	@GetMapping("/user/cpf/{cpf}")
	UserDTO findByCpf(@PathVariable String cpf) {
	    return userService.findByCpf(cpf);
	}
	
	@DeleteMapping("/user/{id}")
	UserDTO delete(@PathVariable Long id) throws UserNotFoundException {
	    return userService.delete(id);
	}
	
}
