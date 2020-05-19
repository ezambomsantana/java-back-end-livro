package com.santana.java.back.end.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.santana.java.back.end.dto.ShopDTO;
import com.santana.java.back.end.service.ShopService;

@RestController
public class ShopController {
	
	@Autowired
	private ShopService shopService;
		
	@GetMapping("/shopping")
	public List<ShopDTO> getShops() {		
		List<ShopDTO> produtos = shopService.getAll();		
		return produtos;
	}
	
	@GetMapping("/shopping/shopByUser/{userIdentifier}")
	public List<ShopDTO> getShops(@PathVariable String userIdentifier) {		
		List<ShopDTO> produtos = shopService.getByUser(userIdentifier);		
		return produtos;
	}
	
	@GetMapping("/shopping/shopByDate")
	public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {		
		List<ShopDTO> produtos = shopService.getByDate(shopDTO);		
		return produtos;
	}
		
	@GetMapping("/shopping/{id}")
	public ShopDTO findById(@PathVariable Long id) {
	    return shopService.findById(id);
	}
	
	@PostMapping("/shopping")
	public ShopDTO newShop(
			@RequestHeader(name = "key", required=true) String key,
			@RequestBody ShopDTO shopDTO) {		
	    return shopService.save(shopDTO, key);
	}
			
}
