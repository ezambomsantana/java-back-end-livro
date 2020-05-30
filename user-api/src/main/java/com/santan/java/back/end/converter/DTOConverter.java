package com.santan.java.back.end.converter;

import com.santana.java.back.end.dto.UserDTO;
import com.santana.java.back.end.model.User;

public class DTOConverter {
	
	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome(user.getNome());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setCpf(user.getCpf());
		userDTO.setKey(user.getKey());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setDataCadastro(user.getDataCadastro());
		return userDTO;
	}
		
}
