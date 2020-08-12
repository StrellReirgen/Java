package com.strell.water.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.water.models.Pool;
import com.strell.water.models.Review;
import com.strell.water.repository.PoolRepository;
import com.strell.water.repository.UserRepository;

@Service
public class PoolService {
	private PoolRepository poolRepo;
	private UserRepository userRepo;
	
	public PoolService(PoolRepository a, UserRepository b) {
		this.poolRepo = a;
		this.userRepo = b;
	}
	
	public void createPool(String direct, String desc, Double cost, String size, Long userid) {
		List<Review> a = new ArrayList<Review>();
		poolRepo.save(new Pool(direct,desc,cost,size,a,userRepo.findById(userid).get()));
	}
	public Pool findPool(Long a) {
		Optional<Pool> item = poolRepo.findById(a);
		if(item.isPresent()) {
            return item.get();
        } else {
            return null;
        }
	}
	public List<Pool> findPoolByAddress(String a) {
		return poolRepo.findByAddressContaining(a);
	}
	public Pool editPool(Pool a) {
    	Optional<Pool> item = poolRepo.findById(a.getId());
        if(item.isPresent()) {
        	item.get().setAddress(a.getAddress());
        	item.get().setDescription(a.getDescription());
        	item.get().setCost(a.getCost());
        	item.get().setSize(a.getSize());
        	return poolRepo.save(item.get());
        } else {
            return null;
        }
        
    }
}
