package com.strell.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.dojo.models.Question;
import com.strell.dojo.repositories.QuestionRepository;

@Service
public class QuestionService {
    private final QuestionRepository QuestRepo;
    
    public QuestionService(QuestionRepository x) {
        this.QuestRepo = x;
    }
    //Devolviendo todas las personas.
    public List<Question> allQuestion() {
        return QuestRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Question findQuestion(Long id) {
    	Optional<Question> user = QuestRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Ingresando a una persona.
    public Question createQuestion(Question c) {
        return QuestRepo.save(c);
    }
    //Actualizar Datos de una Persona.
    public Question updateQuestion(Question b) {
    	Optional<Question> user = QuestRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setTags(b.getTags());
        	return QuestRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteQuestion(Long id) {
    	QuestRepo.deleteById(id);
    }
}
