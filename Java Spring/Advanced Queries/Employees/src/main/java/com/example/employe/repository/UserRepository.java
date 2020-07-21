package com.example.employe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employe.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	User FindById(Long id);

}
