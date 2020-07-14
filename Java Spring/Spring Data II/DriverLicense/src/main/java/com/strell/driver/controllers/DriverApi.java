package com.strell.driver.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.strell.driver.models.License;
import com.strell.driver.models.Person;
import com.strell.driver.services.LicenseService;
import com.strell.driver.services.PersonService;

@RestController
public class DriverApi {
	private final PersonService PersonServ;
	private final LicenseService LicenServ;
	public DriverApi(PersonService a, LicenseService b){
        this.PersonServ = a;
        this.LicenServ = b;
    }
	@RequestMapping("/api/persons")
    public List<Person> indexA() {
        return PersonServ.allPerson();
    }
	
	@RequestMapping(value="/api/persons", method=RequestMethod.POST)
    public Person createP(@RequestParam(value="firstName") String nombre, @RequestParam(value="lastName") String apellido, @RequestParam(value="rut") String run) {
		Person user = new Person(nombre, apellido, run);
        return PersonServ.createPerson(user);
    }
	@RequestMapping("/api/persons/{id}")
    public Person showP(@PathVariable("id") Long id) {
        return PersonServ.findPerson(id);
    }
	@RequestMapping(value="/api/persons/{id}", method=RequestMethod.PUT)
    public Person updateP(@PathVariable("id") Long id, @RequestParam(value="firstName") String nombre, @RequestParam(value="lastName") String apellido, @RequestParam(value="rut") String run) {
		Person user = new Person(nombre, apellido, run);
        return PersonServ.updatePerson(user);
    }
	@RequestMapping(value="/api/persons/{id}", method=RequestMethod.DELETE)
    public void destroyP(@PathVariable("id") Long id) {
		PersonServ.deletePerson(id);
    }
	
	@RequestMapping("/api/licenses")
    public List<License> indexB() {
        return LicenServ.allLicense();
    }
	@RequestMapping("/api/licenses/{id}")
    public License showL(@PathVariable("id") Long id) {
        return LicenServ.findLicense(id);
    }
	@RequestMapping(value="/api/licenses/{id}", method=RequestMethod.DELETE)
    public void destroyL(@PathVariable("id") Long id) {
		LicenServ.deleteLicense(id);
    }
}
