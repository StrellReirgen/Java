package com.strell.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.lookify.models.Song;
import com.strell.lookify.repositories.SongRepository;

@Service
public class SongService {
	//Agregando el book al repositorio como una dependencia
    private final SongRepository SongRepo;
    
    public SongService(SongRepository b) {
        this.SongRepo = b;
    }
    //Devolviendo todos los libros.
    public List<Song> allSongs() {
        return SongRepo.findAll();
    }
    public List<Song> allSongsByArtist(String a) {
        return SongRepo.findByArtistContaining(a);
    }
    public List<Song> getTopSongs(){
		return SongRepo.findTop10ByOrderByRatingDesc();
	}
    //Creando un libro.
    public Song createSong(Song b) {
        return SongRepo.save(b);
    }
    //Obteniendo la información de un libro
    public Song findSong(Long id) {
        Optional<Song> lang = SongRepo.findById(id);
        if(lang.isPresent()) {
            return lang.get();
        } else {
            return null;
        }
    }
  //actualizando la información de un libro
    public Song updateSong(Long id, String titulo, String artista, String ruta,Integer valor) {
    	Optional<Song> lang = SongRepo.findById(id);
        if(lang.isPresent()) {
        	lang.get().setTitle(titulo);
        	lang.get().setArtist(artista);
        	lang.get().setUrl(ruta);
        	lang.get().setRating(valor);
        	return SongRepo.save(lang.get());
        } else {
            return null;
        }
        
    }
    public Song updateSong(Song b) {
    	Optional<Song> lang = SongRepo.findById(b.getId());
    	if(lang.isPresent()) {
        	lang.get().setTitle(b.getTitle());
        	lang.get().setArtist(b.getArtist());
        	lang.get().setUrl(b.getUrl());
        	lang.get().setRating(b.getRating());
        	return SongRepo.save(lang.get());
        } else {
            return null;
        }
        
    }
    //Eliminando un libro
    public void deleteSong(Long id) {
    	SongRepo.deleteById(id);
    }
    
}
