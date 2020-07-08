package com.strell.language.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.strell.language.models.Languages;

@Repository
public interface LanguagesRepository extends CrudRepository<Languages, Long>{
	//Este método recupera todos los Lenguajes de la base de datos
    List<Languages> findAll();
    //Este método encuentra un Lenguajes por su descripción
    List<Languages> findByCreatorContaining(String search);
    //Este método cuenta cuántos Lenguajes contiene cierta cadena en el título
    Long countByNameContaining(String search);
    //Este método borra un Lenguajes que empieza con un título específico
    Long deleteByNameStartingWith(String search);
}
