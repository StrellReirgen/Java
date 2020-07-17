package com.strell.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.student.models.Contact;
import com.strell.student.repositories.ContactRepository;

@Service
public class ContactService {
	private final ContactRepository ContactRepo;
    
    public ContactService(ContactRepository x) {
        this.ContactRepo = x;
    }
    //creando licencia.
    public Contact createContact(Contact c) {
        return ContactRepo.save(c);
    }
    //Devolviendo todas las licencias.
    public List<Contact> allContact() {
        return ContactRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Contact findContact(Long id) {
    	Optional<Contact> user = ContactRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Actualizar Datos de una Persona.
    public Contact updateContact(Contact b) {
    	Optional<Contact> user = ContactRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setCity(b.getCity());
        	user.get().setAddress(b.getAddress());
        	user.get().setState(b.getState());
        	return ContactRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteContact(Long id) {
    	ContactRepo.deleteById(id);
    }
}
