package com.strell.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.dojoninja.models.Ninja;
import com.strell.dojoninja.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository NinjaRepo;
    
    public NinjaService(NinjaRepository x) {
        this.NinjaRepo = x;
    }
    //Devolviendo todas las personas.
    public List<Ninja> allNinja() {
        return NinjaRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Ninja findNinja(Long id) {
    	Optional<Ninja> user = NinjaRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Ingresando a una persona.
    public Ninja createNinja(Ninja c) {
        return NinjaRepo.save(c);
    }
    //Actualizar Datos de una Persona.
    public Ninja updateNinja(Ninja b) {
    	Optional<Ninja> user = NinjaRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setFirstName(b.getFirstName());
        	user.get().setlastName(b.getLastName());
        	user.get().setAge(b.getAge());
        	return NinjaRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteNinja(Long id) {
    	NinjaRepo.deleteById(id);
    }
}
