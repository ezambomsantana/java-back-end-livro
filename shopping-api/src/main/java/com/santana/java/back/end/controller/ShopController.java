package com.santana.java.back.end.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santana.java.back.end.dto.ShopDTO;
import com.santana.java.back.end.service.ShopService;

@RestController
public class ShopController {
	
	@Autowired
	private ShopService shopService;
		
	@GetMapping("/shops")
	public List<ShopDTO> getShops() {		
		List<ShopDTO> produtos = shopService.getAll();		
		return produtos;
	}
	
	@GetMapping("/shopsByUser/{userIdentifier}")
	public List<ShopDTO> getShops(@PathVariable String userIdentifier) {		
		List<ShopDTO> produtos = shopService.getByUser(userIdentifier);		
		return produtos;
	}
	
	@GetMapping("/shopsByDate")
	public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {		
		List<ShopDTO> produtos = shopService.getByDate(shopDTO);		
		return produtos;
	}
		
	@GetMapping("/shop/{id}")
	public ShopDTO findById(@PathVariable Long id) {
	    return shopService.findById(id);
	}
	
	@PostMapping("/newShop")
	public ShopDTO newShop(@RequestBody ShopDTO shopDTO) {		
	    return shopService.save(shopDTO);
	}
			
}
