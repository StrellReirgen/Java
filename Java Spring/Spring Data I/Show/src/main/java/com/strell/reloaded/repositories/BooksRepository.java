package com.strell.reloaded.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.strell.reloaded.models.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long>{
	//Este método recupera todos los libros de la base de datos
    List<Books> findAll();
    //Este método encuentra un libro por su descripción
    List<Books> findByDescriptionContaining(String search);
    //Este método cuenta cuántos libros contiene cierta cadena en el título
    Long countByTitleContaining(String search);
    //Este método borra un libro que empieza con un título específico
    Long deleteByTitleStartingWith(String search);
}
