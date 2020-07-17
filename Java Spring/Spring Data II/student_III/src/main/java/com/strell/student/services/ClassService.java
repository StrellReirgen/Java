package com.strell.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.student.models.Class;
import com.strell.student.repositories.ClassRepository;

@Service
public class ClassService {
    private final ClassRepository ClassRepo;
    
    public ClassService(ClassRepository x) {
        this.ClassRepo = x;
    }
    //Devolviendo todas las personas.
    public List<Class> allClass() {
        return ClassRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Class findClass(Long id) {
    	Optional<Class> user = ClassRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Ingresando a una persona.
    public Class createClass(Class c) {
        return ClassRepo.save(c);
    }
    //Actualizar Datos de una Persona.
    public Class updateClass(Class b) {
    	Optional<Class> user = ClassRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setStudents(b.getStudents());
        	return ClassRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteClass(Long id) {
    	ClassRepo.deleteById(id);
    }
}
