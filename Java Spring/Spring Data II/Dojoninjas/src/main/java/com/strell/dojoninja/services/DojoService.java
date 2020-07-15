package com.strell.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.dojoninja.models.Dojo;
import com.strell.dojoninja.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository DojoRepo;
    
    public DojoService(DojoRepository x) {
        this.DojoRepo = x;
    }
    //creando licencia.
    public Dojo createDojo(Dojo c) {
        return DojoRepo.save(c);
    }
    //Devolviendo todas las licencias.
    public List<Dojo> allDojo() {
        return DojoRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Dojo findDojo(Long id) {
    	Optional<Dojo> user = DojoRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Actualizar Datos de una Persona.
    public Dojo updateDojo(Dojo b) {
    	Optional<Dojo> user = DojoRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setName(b.getName());
        	return DojoRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteDojo(Long id) {
    	DojoRepo.deleteById(id);
    }
}
