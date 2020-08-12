package com.strell.water.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.strell.water.models.Pool;

public interface PoolRepository extends CrudRepository<Pool, Long>{
	List<Pool> findAll();
	
	List<Pool> findByAddressContaining(String search);
}
