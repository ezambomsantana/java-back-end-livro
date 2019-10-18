package com.santana.java.back.end.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santana.java.back.end.dto.UserDTO;
import com.santana.java.back.end.exception.UserNotFoundException;
import com.santana.java.back.end.model.User;
import com.santana.java.back.end.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> getAll() {
		List<User> usuarios = userRepository.findAll();
		return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());		
	}
	
	public UserDTO findById(long userId) {
		Optional<User> usuario = userRepository.findById(userId);
		if (usuario.isPresent()) {
			return UserDTO.convert(usuario.get());
		}
		throw new UserNotFoundException();
	}
	
	public UserDTO save(UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}
	
	public UserDTO delete(long userId) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			userRepository.delete(user.get());
		}
		throw new UserNotFoundException();
	}
	
	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		if (user != null) {
			return UserDTO.convert(user);
		}
		throw new UserNotFoundException();
	}

}