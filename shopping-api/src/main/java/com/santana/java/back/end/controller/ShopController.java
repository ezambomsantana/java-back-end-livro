package com.santana.java.back.end.controller;

import java.time.LocalDate;
import java.util.List;


import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.santana.java.back.end.dto.ShopDTO;
import com.santana.java.back.end.dto.ShopReportDTO;
import com.santana.java.back.end.service.ShopService;

@RestController
@RequiredArgsConstructor
public class 	ShopController {

	private final ShopService shopService;
		
	@GetMapping("/shopping")
	public List<ShopDTO> getShops() {		
		return shopService.getAll();
	}
	
	@GetMapping("/shopping/shopByUser/{userIdentifier}")
	public List<ShopDTO> getShops(@PathVariable String userIdentifier) {		
		return shopService.getByUser(userIdentifier);
	}
	
	@GetMapping("/shopping/shopByDate")
	public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {		
		return shopService.getByDate(shopDTO);
	}
		
	@GetMapping("/shopping/{id}")
	public ShopDTO findById(@PathVariable Long id) {
	    return shopService.findById(id);
	}
	
	@PostMapping("/shopping/")
	@ResponseStatus(HttpStatus.CREATED)
	public ShopDTO newShop(
			@RequestHeader(name = "key", required=true) String key,
			@RequestBody ShopDTO shopDTO) {		
	    return shopService.save(shopDTO, key);
	}
	
	@GetMapping("/shopping/search")
	public List<ShopDTO> getShopsByFilter(
			@RequestParam(name = "dataInicio", required=true) 
				@DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicio,
			@RequestParam(name = "dataFim", required=false) 
				@DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFim,
			@RequestParam(name = "valorMinimo", required=false) Float valorMinimo) {		
	    return shopService.getShopsByFilter(dataInicio, dataFim, valorMinimo);
	}
	
	@GetMapping("/shopping/report")
	public ShopReportDTO getReportByDate(
			@RequestParam(name = "dataInicio", required=true) 
				@DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicio,
			@RequestParam(name = "dataFim", required=true) 
				@DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFim) {
	    return shopService.getReportByDate(dataInicio, dataFim);
	}
			
}
