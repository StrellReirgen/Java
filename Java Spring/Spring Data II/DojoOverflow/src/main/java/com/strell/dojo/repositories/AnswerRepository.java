package com.strell.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.strell.dojo.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
}
