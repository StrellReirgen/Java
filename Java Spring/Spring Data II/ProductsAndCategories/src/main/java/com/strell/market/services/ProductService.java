package com.strell.market.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.market.models.Product;
import com.strell.market.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository ProRepo;
    
    public ProductService(ProductRepository x) {
        this.ProRepo = x;
    }
    //creando licencia.
    public Product createProduct(Product c) {
        return ProRepo.save(c);
    }
    //Devolviendo todas las licencias.
    public List<Product> allProduct() {
        return ProRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Product findProduct(Long id) {
    	Optional<Product> user = ProRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Actualizar Datos de una Persona.
    public Product updateProduct(Product b) {
    	Optional<Product> user = ProRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setCategories(b.getCategories());
        	return ProRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteProduct(Long id) {
    	ProRepo.deleteById(id);
    }
}
