package com.santana.java.back.end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

	@NotBlank
	private String userIdentifier;
	@NotNull
	private Float total;
	@NotNull
	private LocalDateTime date;
	@NotNull
	private List<ItemDTO> items;

}
