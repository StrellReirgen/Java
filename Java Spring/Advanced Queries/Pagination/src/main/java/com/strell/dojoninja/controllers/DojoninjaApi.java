package com.strell.dojoninja.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.strell.dojoninja.models.Dojo;
import com.strell.dojoninja.models.Ninja;
import com.strell.dojoninja.services.DojoService;
import com.strell.dojoninja.services.NinjaService;

@RestController
public class DojoninjaApi {
	private final NinjaService NinjaServ;
	private final DojoService DojoServ;
	public DojoninjaApi(NinjaService a, DojoService b){
        this.NinjaServ = a;
        this.DojoServ = b;
    }
	@RequestMapping("/api/ninja")
    public List<Ninja> indexA() {
        return NinjaServ.allNinja();
    }
	
	@RequestMapping(value="/api/ninja", method=RequestMethod.POST)
    public Ninja createP(@RequestParam(value="firstName") String nombre, @RequestParam(value="lastName") String apellido, @RequestParam(value="age") Integer edad, @RequestParam(value="dojo") Long lugar) {
		Dojo dojo = DojoServ.findDojo(lugar);
		Ninja user = new Ninja(nombre, apellido, edad, dojo);
        return NinjaServ.createNinja(user);
    }
	@RequestMapping("/api/ninja/{id}")
    public Ninja showP(@PathVariable("id") Long id) {
        return NinjaServ.findNinja(id);
    }
	@RequestMapping(value="/api/ninja/{id}", method=RequestMethod.PUT)
    public Ninja updateP(@PathVariable("id") Long id, @RequestParam(value="firstName") String nombre, @RequestParam(value="lastName") String apellido, @RequestParam(value="age") Integer edad) {
		Ninja user = NinjaServ.findNinja(id);
        user.setFirstName(nombre);
        user.setlastName(apellido);
        user.setAge(edad);
        return NinjaServ.updateNinja(user);
    }
	@RequestMapping(value="/api/ninja/{id}", method=RequestMethod.DELETE)
    public void destroyP(@PathVariable("id") Long id) {
		NinjaServ.deleteNinja(id);
    }
	
	@RequestMapping("/api/dojo")
    public List<Dojo> indexB() {
        return DojoServ.allDojo();
    }
	@RequestMapping(value="/api/dojo", method=RequestMethod.POST)
    public Dojo createL(@RequestParam(value="name") String nombre) {
		List<Ninja> user = new ArrayList<Ninja>();
		Dojo lugar= new Dojo(nombre, user);
        return DojoServ.createDojo(lugar);
    }
	@RequestMapping("/api/dojo/{id}")
    public Dojo showL(@PathVariable("id") Long id) {
        return DojoServ.findDojo(id);
    }
	@RequestMapping(value="/api/dojo/{id}", method=RequestMethod.PUT)
    public Dojo updateL(@PathVariable("id") Long id, @RequestParam(value="name") String nombre) {
		Dojo user = DojoServ.findDojo(id);
        user.setName(nombre);
        return DojoServ.updateDojo(user);
    }
	@RequestMapping(value="/api/dojo/{id}", method=RequestMethod.DELETE)
    public void destroyL(@PathVariable("id") Long id) {
		DojoServ.deleteDojo(id);
    }
}
