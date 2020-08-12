package com.strell.water.services;

import org.springframework.stereotype.Service;

import com.strell.water.models.Review;
import com.strell.water.repository.ReviewRepository;

@Service
public class ReviewService {
	private ReviewRepository revRepo;
	
	public ReviewService (ReviewRepository a) {
		this.revRepo = a;
	}
	
	public void createRev(Review a) {
		revRepo.save(a);
	}
}
