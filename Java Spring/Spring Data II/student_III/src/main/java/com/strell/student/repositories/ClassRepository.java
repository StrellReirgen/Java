package com.strell.student.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.strell.student.models.Class;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long>{
	List<Class> findAll();
}
