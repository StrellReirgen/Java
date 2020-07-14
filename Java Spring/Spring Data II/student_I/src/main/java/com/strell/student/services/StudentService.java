package com.strell.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.student.models.Student;
import com.strell.student.repositories.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository StudentRepo;
    
    public StudentService(StudentRepository x) {
        this.StudentRepo = x;
    }
    //Devolviendo todas las personas.
    public List<Student> allStudent() {
        return StudentRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Student findStudent(Long id) {
    	Optional<Student> user = StudentRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Ingresando a una persona.
    public Student createStudent(Student c) {
        return StudentRepo.save(c);
    }
    //Actualizar Datos de una Persona.
    public Student updateStudent(Student b) {
    	Optional<Student> user = StudentRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setFirstName(b.getFirstName());
        	user.get().setlastName(b.getLastName());
        	user.get().setAge(b.getAge());
        	return StudentRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteStudent(Long id) {
    	StudentRepo.deleteById(id);
    }
}
