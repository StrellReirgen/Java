package com.strell.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.dojo.models.Tag;
import com.strell.dojo.repositories.TagRepository;

@Service
public class TagService {
    private final TagRepository TagRepo;
    
    public TagService(TagRepository x) {
        this.TagRepo = x;
    }
    //Devolviendo todas las personas.
    public List<Tag> allTag() {
        return TagRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Tag findTag(Long id) {
    	Optional<Tag> user = TagRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Ingresando a una persona.
    public Tag createTag(Tag c) {
        return TagRepo.save(c);
    }
    //Actualizar Datos de una Persona.
    public Tag updateTag(Tag b) {
    	Optional<Tag> user = TagRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setQuestions(b.getQuestions());
        	return TagRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteTag(Long id) {
    	TagRepo.deleteById(id);
    }
}
