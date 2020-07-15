package com.strell.student.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.strell.student.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	List<Contact> findAll();
}
