package com.santana.java.back.end.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santana.java.back.end.dto.ShopDTO;
import com.santana.java.back.end.model.Shop;
import com.santana.java.back.end.repository.ShopRepository;

@Service
public class ShopService {
	
	@Autowired
	private ShopRepository shopRepository;
		
	public List<ShopDTO> getAll() {
		List<Shop> shops = shopRepository.findAll();
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());		
	}
	
	public List<ShopDTO> getByUser(String userIdentifier) {
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());		
	}
		
	public List<ShopDTO> getByDate(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());		
	}
		
	public ShopDTO findById(long ProductId) {
		Optional<Shop> shop = shopRepository.findById(ProductId);
		if (shop.isPresent()) {
			return ShopDTO.convert(shop.get());
		}
		return null;
		//throw new ProductNotFoundException();
	}
	
	public ShopDTO save(ShopDTO shopDTO) {			
		
		shopDTO.setTotal(shopDTO.getItems()
				  .stream()
				  .map(x -> x.getPrice())
				  .reduce((float) 0, Float::sum));
		
		Shop shop = Shop.convert(shopDTO);
		shop.setDate(new Date());
		
		shop = shopRepository.save(shop);
		return ShopDTO.convert(shop);
	}
	
}
