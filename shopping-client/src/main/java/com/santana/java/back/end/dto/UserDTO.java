package com.santana.java.back.end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private String nome;
	private String cpf;
	private String endereco;
	private String key;
	private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
}
