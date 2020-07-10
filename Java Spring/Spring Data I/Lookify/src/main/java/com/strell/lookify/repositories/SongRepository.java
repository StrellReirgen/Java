package com.strell.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.strell.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	//Este método recupera todos los Lenguajes de la base de datos
    List<Song> findAll();
    //Este método encuentra un cancion por su titulo
    List<Song> findByArtistContaining(String search);
    //Este método cuenta cuántas canciones contiene cierta cadena en el título
    Long countByTitleContaining(String search);
    //Este método borra un cancion que empieza con un título específico
    Long deleteByTitleStartingWith(String search);
}
