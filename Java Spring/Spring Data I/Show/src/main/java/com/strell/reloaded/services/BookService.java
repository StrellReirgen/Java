package com.strell.reloaded.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.reloaded.models.Books;
import com.strell.reloaded.repositories.BooksRepository;

@Service
public class BookService {
	//Agregando el book al repositorio como una dependencia
    private final BooksRepository bookRepository;
    
    public BookService(BooksRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Devolviendo todos los libros.
    public List<Books> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Books createBook(Books b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Books findBook(Long id) {
        Optional<Books> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
  //actualizando la información de un libro
    public Books updateBook(Long id, String title, String desc, String lang, Integer pages) {
    	Optional<Books> book = bookRepository.findById(id);
        if(book.isPresent()) {
        	book.get().setTitle(title);
        	book.get().setDescription(desc);
        	book.get().setLanguage(lang);
        	book.get().setNumberOfPages(pages);
        	return bookRepository.save(book.get());
        } else {
            return null;
        }
        
    }
    //Eliminando un libro
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
}
