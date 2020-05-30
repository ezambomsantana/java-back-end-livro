package com.santana.java.back.end.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santana.java.back.end.dto.UserDTO;
import com.santana.java.back.end.exception.UserNotFoundException;
import com.santana.java.back.end.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@GetMapping("/user/")
	public List<UserDTO> getUsers() {		
		List<UserDTO> usuarios = userService.getAll();		
		return usuarios;
	}
	
	@GetMapping("/user/{id}")
	public UserDTO findById(@PathVariable Long id) {
	    return userService.findById(id);
	}
	
	@PostMapping("/user")
	public UserDTO newUser(@RequestBody UserDTO userDTO) {		
	    return userService.save(userDTO);
	}
	
	@GetMapping("/user/cpf/{cpf}")
	public UserDTO findByCpf(
			@RequestParam(name="key") String key,
			@PathVariable String cpf) {
	    return userService.findByCpf(cpf, key);
	}
	
	@DeleteMapping("/user/{id}")
	public UserDTO delete(@PathVariable Long id) throws UserNotFoundException {
	    return userService.delete(id);
	}
	
	@GetMapping("/user/search")
	public List<UserDTO> queryByName(
			@RequestParam(name="nome", required = true) String nome) {
	    return userService.queryByName(nome);
	}
	
}
