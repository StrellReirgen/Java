package com.strell.language.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.strell.language.models.Languages;
import com.strell.language.services.LanguagesService;

@RestController
public class LanguagesApi {
	private final LanguagesService LangService;
	public LanguagesApi(LanguagesService b){
        this.LangService = b;
    }
	@RequestMapping("/api/languages")
    public List<Languages> index() {
        return LangService.allLanguages();
    }
	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Languages create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Languages lang = new Languages(name, creator, version);
        return LangService.createLanguage(lang);
    }
	@RequestMapping("/api/languages/{id}")
    public Languages show(@PathVariable("id") Long id) {
		Languages lang = LangService.findLanguage(id);
        return lang;
    }
	@RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Languages update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Languages lang = LangService.updateLanguage(id, name, creator, version);
        return lang;
    }
	@RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
		LangService.deleteLanguage(id);
    }
}
