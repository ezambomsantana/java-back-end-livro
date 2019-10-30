package com.santana.java.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santana.java.back.end.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
