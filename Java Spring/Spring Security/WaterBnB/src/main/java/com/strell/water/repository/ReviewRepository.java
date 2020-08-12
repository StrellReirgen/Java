package com.strell.water.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.strell.water.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long>{
	List<Review> findAll();
}
