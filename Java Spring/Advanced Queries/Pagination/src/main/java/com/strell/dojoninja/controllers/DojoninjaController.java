package com.strell.dojoninja.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.strell.dojoninja.models.Dojo;
import com.strell.dojoninja.models.Ninja;
import com.strell.dojoninja.services.DojoService;
import com.strell.dojoninja.services.NinjaService;

@Controller
public class DojoninjaController {
	private final NinjaService NinjaServ;
	private final DojoService DojoServ;
	public DojoninjaController(NinjaService a, DojoService b){
        this.NinjaServ = a;
        this.DojoServ = b;
    }
	@RequestMapping("/")
    public String index(Model model) {
        List<Dojo> dojo = DojoServ.allDojo();
        model.addAttribute("lugar", dojo);
        return "/index.jsp";
    }
	@RequestMapping("/dojo/new")
    public String newDojo() {
        return "/dojo/newd.jsp";
    }
	@RequestMapping(value="/dojo/new", method=RequestMethod.POST)
    public String createDojo(@RequestParam("dojo") String nombre) {
		List<Ninja> user = new ArrayList<Ninja>();
		Dojo lugar= new Dojo(nombre, user);
        DojoServ.createDojo(lugar);
		return "redirect:/";
        
    }
	@RequestMapping("/dojo/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Dojo user = DojoServ.findDojo(id);
        model.addAttribute("dojo", user);
        return "/dojo/dojo.jsp";
    }
	@RequestMapping(value="/dojo/{id}", method=RequestMethod.DELETE)
    public String destroyDojo(@PathVariable("id") Long id) {
		DojoServ.deleteDojo(id);
		return "redirect:/";
    }
	@RequestMapping(value="/ninja/{id}", method=RequestMethod.DELETE)
    public String destroyNinja(@PathVariable("id") Long id) {
		NinjaServ.deleteNinja(id);
		return "redirect:/";
    }
	@RequestMapping("/ninja/new")
    public String newNinja(Model model) {
		List<Dojo> dojo = DojoServ.allDojo();
        model.addAttribute("lugar", dojo);
        return "/ninja/newn.jsp";
    }
	@RequestMapping(value="/ninja/new", method=RequestMethod.POST)
    public String createNinja(@RequestParam("dojo") Long id, @RequestParam("name") String nombre, @RequestParam("lastname") String apellido, @RequestParam("age") Integer edad) {
		Dojo dojo = DojoServ.findDojo(id);
		Ninja user = new Ninja(nombre, apellido, edad, dojo);
        NinjaServ.createNinja(user);
		return "redirect:/";
    }
}
