package com.strell.market.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.market.models.Category;
import com.strell.market.repositories.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository CateRepo;
    
    public CategoryService(CategoryRepository x) {
        this.CateRepo = x;
    }
    //Devolviendo todas las personas.
    public List<Category> allCategory() {
        return CateRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Category findCategory(Long id) {
    	Optional<Category> user = CateRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Ingresando a una persona.
    public Category createCategory(Category c) {
        return CateRepo.save(c);
    }
    //Actualizar Datos de una Persona.
    public Category updateCategory(Category b) {
    	Optional<Category> user = CateRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setProducts(b.getProducts());
        	return CateRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteCategory(Long id) {
    	CateRepo.deleteById(id);
    }
}
