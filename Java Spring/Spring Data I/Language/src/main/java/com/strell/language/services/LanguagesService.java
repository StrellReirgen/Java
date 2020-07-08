package com.strell.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.language.models.Languages;
import com.strell.language.repositories.LanguagesRepository;

@Service
public class LanguagesService {
	//Agregando el book al repositorio como una dependencia
    private final LanguagesRepository LangRepo;
    
    public LanguagesService(LanguagesRepository b) {
        this.LangRepo = b;
    }
    //Devolviendo todos los libros.
    public List<Languages> allLanguages() {
        return LangRepo.findAll();
    }
    //Creando un libro.
    public Languages createLanguage(Languages b) {
        return LangRepo.save(b);
    }
    //Obteniendo la información de un libro
    public Languages findLanguage(Long id) {
        Optional<Languages> lang = LangRepo.findById(id);
        if(lang.isPresent()) {
            return lang.get();
        } else {
            return null;
        }
    }
  //actualizando la información de un libro
    public Languages updateLanguage(Long id, String nombre, String creador, String valor) {
    	Optional<Languages> lang = LangRepo.findById(id);
        if(lang.isPresent()) {
        	lang.get().setName(nombre);
        	lang.get().setCreator(creador);
        	lang.get().setVersion(valor);
        	return LangRepo.save(lang.get());
        } else {
            return null;
        }
        
    }
    public Languages updateLanguage(Languages b) {
    	Optional<Languages> lang = LangRepo.findById(b.getId());
    	if(lang.isPresent()) {
        	lang.get().setName(b.getName());
        	lang.get().setCreator(b.getCreator());
        	lang.get().setVersion(b.getVersion());
        	return LangRepo.save(lang.get());
        } else {
            return null;
        }
        
    }
    //Eliminando un libro
    public void deleteLanguage(Long id) {
    	LangRepo.deleteById(id);
    }
    
}
