package com.strell.driver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.driver.models.Person;
import com.strell.driver.repositories.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository PersonRepo;
    
    public PersonService(PersonRepository x) {
        this.PersonRepo = x;
    }
    //Devolviendo todas las personas.
    public List<Person> allPerson() {
        return PersonRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Person findPerson(Long id) {
    	Optional<Person> user = PersonRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Devolviendo a una Persona por Rut.
    public Person findPersonByRut(String b) {
        return PersonRepo.getPersonByRut(b);
    }
    //Ingresando a una persona.
    public Person createPerson(Person c) {
        return PersonRepo.save(c);
    }
    //Actualizar Datos de una Persona.
    public Person updatePerson(Person b) {
    	Optional<Person> user = PersonRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setFirstName(b.getFirstName());
        	user.get().setlastName(b.getLastName());
        	user.get().setRut(b.getRut());
        	return PersonRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deletePerson(Long id) {
    	PersonRepo.deleteById(id);
    }
}
