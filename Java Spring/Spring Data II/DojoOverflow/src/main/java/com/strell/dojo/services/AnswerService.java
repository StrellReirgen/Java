package com.strell.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.dojo.models.Answer;
import com.strell.dojo.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository AnsRepo;
    
    public AnswerService(AnswerRepository x) {
        this.AnsRepo = x;
    }
    //creando licencia.
    public Answer createAnswer(Answer c) {
        return AnsRepo.save(c);
    }
    //Devolviendo todas las licencias.
    public List<Answer> allAnswer() {
        return AnsRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Answer findAnswer(Long id) {
    	Optional<Answer> user = AnsRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Actualizar Datos de una Persona.
    public Answer updateAnswer(Answer b) {
    	Optional<Answer> user = AnsRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setAnswer(b.getAnswer());
        	return AnsRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteAnswer(Long id) {
    	AnsRepo.deleteById(id);
    }
}
