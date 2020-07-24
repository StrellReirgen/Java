package com.strell.repaso.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.strell.repaso.models.Coment;


@Repository
public interface ComentRepository extends CrudRepository <Coment, Long>{
	List<Coment> findAll();
}
