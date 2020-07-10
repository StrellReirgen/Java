package com.strell.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.strell.lookify.models.Song;
import com.strell.lookify.services.SongService;

@RestController
public class SongApi {
	private final SongService SongServ;
	public SongApi(SongService b){
        this.SongServ = b;
    }
	@RequestMapping("/api/songs")
    public List<Song> index() {
        return SongServ.allSongs();
    }
	@RequestMapping(value="/api/songs", method=RequestMethod.POST)
    public Song create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="url") String ruta,@RequestParam(value="version") Integer version) {
		Song lang = new Song(name, creator, ruta,version);
        return SongServ.createSong(lang);
    }
	@RequestMapping("/api/songs/{id}")
    public Song show(@PathVariable("id") Long id) {
		Song lang = SongServ.findSong(id);
        return lang;
    }
	@RequestMapping(value="/api/songs/{id}", method=RequestMethod.PUT)
    public Song update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="url") String ruta ,@RequestParam(value="version") Integer version) {
		Song lang = SongServ.updateSong(id, name, creator, ruta, version);
        return lang;
    }
	@RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
		SongServ.deleteSong(id);
    }
}
