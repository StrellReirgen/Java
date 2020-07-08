package com.strell.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.strell.language.models.Languages;
import com.strell.language.services.LanguagesService;

@Controller
public class LanguagesController {
	private final LanguagesService LangService;
	public LanguagesController(LanguagesService b){
        this.LangService = b;
    }
	@RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("dato") Languages code) {
        List<Languages> lang = LangService.allLanguages();
        model.addAttribute("lenguajes", lang);
        return "/languages/index.jsp";
    }
	@RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dato") Languages code, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/languages";
        } else {
        	LangService.createLanguage(code);
            return "redirect:/languages";
        }
    }
	@RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Languages show = LangService.findLanguage(id);
        model.addAttribute("lenguaje", show);
        return "/languages/info.jsp";
    }
	@RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
		Languages show = LangService.findLanguage(id);
        model.addAttribute("lenguaje", show);
        return "/languages/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("lenguaje") Languages lang, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
        	LangService.updateLanguage(lang);
            return "redirect:/languages";
        }
    }
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	LangService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
