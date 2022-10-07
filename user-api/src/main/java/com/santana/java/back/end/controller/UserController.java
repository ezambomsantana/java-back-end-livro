package com.santana.java.back.end.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.santana.java.back.end.dto.UserDTO;
import com.santana.java.back.end.exception.UserNotFoundException;
import com.santana.java.back.end.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/pageable")
	public Page<UserDTO> getUsersPage(Pageable pageable) {
		return userService.getAllPage(pageable);
	}
		
	@GetMapping
	public List<UserDTO> getUsers() {		
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable Long id) {
	    return userService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO newUser(@RequestBody UserDTO userDTO) {		
	    return userService.save(userDTO);
	}

	@PostMapping("/{id}")
	public UserDTO editUser(@PathVariable Long id,
							@RequestBody UserDTO userDTO) {
		return userService.editUser(id, userDTO);
	}
	
	@GetMapping("/{cpf}/cpf")
	public UserDTO findByCpf(
			@RequestParam(name="key") String key,
			@PathVariable String cpf) {
	    return userService.findByCpf(cpf, key);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws UserNotFoundException {
		userService.delete(id);
	}
	
	@GetMapping("/search")
	public List<UserDTO> queryByName(
			@RequestParam(name="nome", required = true) String nome) {
		return userService.queryByName(nome);
	}
	
}
