package com.strell.driver.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.strell.driver.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
    //Este método encuentra un cancion por su titulo
    Person getPersonByRut(String search);
}
