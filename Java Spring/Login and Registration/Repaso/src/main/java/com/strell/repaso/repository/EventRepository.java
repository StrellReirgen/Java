package com.strell.repaso.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.strell.repaso.models.Event;


@Repository
public interface EventRepository extends CrudRepository <Event, Long>{
	List<Event> findAll();
	
	List<Event> findByRegionContaining(String Region);
}
