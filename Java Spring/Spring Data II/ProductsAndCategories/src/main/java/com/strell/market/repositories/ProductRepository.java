package com.strell.market.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.strell.market.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
}
