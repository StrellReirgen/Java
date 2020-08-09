package com.example.employe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employe.models.Employees;




@Repository
public interface UserRepository extends CrudRepository<Employees, Long>{
	
	Employees FindById(Long id);

}
