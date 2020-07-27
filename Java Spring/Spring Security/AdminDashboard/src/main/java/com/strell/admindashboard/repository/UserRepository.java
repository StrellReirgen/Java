package com.strell.admindashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.strell.admindashboard.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
