package com.santana.java.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santana.java.back.end.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
		
}
