package com.strell.driver.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.strell.driver.models.Person;
import com.strell.driver.services.PersonService;

@Controller
@RequestMapping("/")
public class DriverController {
	private final PersonService SongServ;
	public DriverController(PersonService b){
        this.SongServ = b;
    }
	
    public String index(Model model) {
        List<Person> lang = SongServ.allPerson();
        model.addAttribute("canciones", lang);
        return "/index.jsp";
    }
	@RequestMapping("/search/{name}")
    public String artist(@PathVariable("name") String name, Model model) {
		List<Person> lang = SongServ.allSongsByArtist(name);
        model.addAttribute("canciones", lang);
        model.addAttribute("dashboard", "<a href=\"/dashboard\" class=\"btn btn-warning\">Dashboard</a>");
        return "/songs/index.jsp";
    }
	@RequestMapping("/search/topten")
    public String top(Model model) {
		List<Person> lang = SongServ.allPerson();
		List<Person> top = new ArrayList<Person>();
		for (int i = 0 ;i<lang.size(); i++) {
			if (top.size()<10) {
				top.add(lang.get(i));
			} else {
				Person menor = top.get(0);
				int id = 0;
				for (int e = 0 ;e<top.size(); e++) {
					if (top.get(e).getRating()<menor.getRating()) {
						menor=top.get(e);
						id = e;
					}
				}
				if (lang.get(i).getRating()>menor.getRating()) {
					top.set(id, lang.get(i));
				}
			}
		}
        model.addAttribute("canciones", top);
        model.addAttribute("dashboard", "<a href=\"/dashboard\" class=\"btn btn-warning\">Dashboard</a>");
        return "/songs/index.jsp";
    }
	@RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("dato") Person code) {
        return "/songs/new.jsp";
    }
	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dato") Person code, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/songs/new";
        } else {
        	SongServ.createSong(code);
            return "redirect:/dashboard";
        }
    }
	@RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Person show = SongServ.findSong(id);
        model.addAttribute("cancion", show);
        return "/songs/song.jsp";
    }
	@RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
		Person show = SongServ.findSong(id);
        model.addAttribute("cancion", show);
        return "/songs/edit.jsp";
    }
    
    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("cancion") Person lang, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/songs/"+lang.getId()+"/edit";
        } else {
        	SongServ.updateSong(lang);
            return "redirect:/dashboard";
        }
    }
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	SongServ.deleteSong(id);
        return "redirect:/dashboard";
    }
}
